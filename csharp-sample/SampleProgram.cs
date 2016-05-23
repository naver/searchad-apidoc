using RestSharp;
using System.Collections.Generic;
using System.Configuration;

namespace Naver.SearchAd
{
    class SampleProgram
    {
        static void Main(string[] args)
        {
            var baseUrl = ConfigurationManager.AppSettings["BASE_URL"];
            var apiKey = ConfigurationManager.AppSettings["API_KEY"];
            var secretKey = ConfigurationManager.AppSettings["SECRET_KEY"];
            var managerCustomerId = long.Parse(ConfigurationManager.AppSettings["CUSTOMER_ID"]);

            var rest = new SearchAdApi(baseUrl, apiKey, secretKey);

            var request = new RestRequest("/customer-links", Method.GET);
            request.AddQueryParameter("type", "MYCLIENTS");
            List<CustomerLink> customerLinks = rest.Execute<List<CustomerLink>>(request, managerCustomerId);

            long customerId = customerLinks[0].ClientCustomerId;

            request = new RestRequest("/ncc/campaigns", Method.GET);
            List<Campaign> campaigns = rest.Execute<List<Campaign>>(request, customerId);
        }
    }
}
