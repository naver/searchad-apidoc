using RestSharp;
using System;
using System.Linq;
using System.Security.Cryptography;
using System.Text;

namespace Naver.SearchAd
{
    class SearchAdApi
    {
        private readonly string BaseUrl;
        private readonly string ApiKey;
        private readonly string SecretKey;
        private readonly HMACSHA256 HMAC;

        public SearchAdApi(string baseUrl, string apiKey, string secretKey)
        {
            this.BaseUrl = baseUrl;
            this.ApiKey = apiKey;
            this.SecretKey = secretKey;
            this.HMAC = new HMACSHA256(Encoding.UTF8.GetBytes(secretKey));
        }

        public T Execute<T>(RestRequest request, long customerId) where T : new()
        {
            var client = new RestClient(BaseUrl);

            var timestamp = getTimestamp().ToString();
            var signature = generateSignature(timestamp, request.Method.ToString(), request.Resource);

            request.AddHeader("X-API-KEY", ApiKey);
            request.AddHeader("X-Customer", customerId.ToString());
            request.AddHeader("X-Timestamp", timestamp);
            request.AddHeader("X-Signature", signature);

            printRequest(request);

            var response = client.Execute<T>(request);

            printResponse(response);

            if (response.ErrorException != null)
            {
                throw new ApplicationException("Error retrieving response. Check inner details for more info.", response.ErrorException);
            }
            return response.Data;
        }

        private long getTimestamp()
        {
            return (long)(DateTime.UtcNow - new DateTime(1970, 1, 1)).TotalMilliseconds;
        }

        private string generateSignature(string timestamp, string method, string resource)
        {
            return Convert.ToBase64String(HMAC.ComputeHash(Encoding.UTF8.GetBytes(timestamp + "." + method + "." + resource)));
        }

        private static readonly Func<Parameter, bool> IS_HEADER = param => param.Type == ParameterType.HttpHeader;
        private static readonly Func<Parameter, bool> IS_QUERYPARAM = param => param.Type == ParameterType.QueryString;

        private void printRequest(RestRequest request)
        {
            Console.WriteLine("============ Request =============");
            Console.Write(request.Method + " " + request.Resource);

            var queryParams = request.Parameters.Where(IS_QUERYPARAM).ToList();
            Console.WriteLine(queryParams.Count > 0 ? "?" + string.Join("&", queryParams) : "");

            request.Parameters.Where(IS_HEADER).ToList().ForEach(Console.WriteLine);
            Console.WriteLine();
        }

        private void printResponse(IRestResponse response)
        {
            Console.WriteLine("============ Response ============");
            Console.WriteLine(((int)response.StatusCode) + " " + response.StatusCode);

            foreach (Parameter param in response.Headers)
            {
                Console.WriteLine(param);
            }

            Console.WriteLine();
            Console.WriteLine(response.Content);
            Console.WriteLine();
        }
    }
}
