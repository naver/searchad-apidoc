package com.naver.searchad.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SignatureException;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestClient {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final boolean DEBUG_MODE = true;

	private static boolean initialized = false;

	private final String baseUrl;
	private final String apiKey;
	private final String secretKey;

	public static synchronized RestClient of(String baseUrl, String apiKey, String secretKey) throws GeneralSecurityException {
		if (!initialized) {
			Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
				public <T> T readValue(String value, Class<T> valueType) {
					try {
						if (DEBUG_MODE) {
							System.out.println(value);
						}
						return OBJECT_MAPPER.readValue(value, valueType);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}

				public String writeValue(Object value) {
					try {
						String result = OBJECT_MAPPER.writeValueAsString(value);
						if (DEBUG_MODE) {
							System.out.println(result);
						}
						return result;
					} catch (JsonProcessingException e) {
						throw new RuntimeException(e);
					}
				}
			});

			HttpClientBuilder httpClientBuilder = HttpClients.custom();
			if (baseUrl.startsWith("https://")) {
				SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
						new SSLContextBuilder()
								.loadTrustMaterial(null, new TrustSelfSignedStrategy())
								.build());
				httpClientBuilder.setSSLSocketFactory(sslSocketFactory);
			}
			if (DEBUG_MODE) {
				httpClientBuilder.addInterceptorFirst((org.apache.http.HttpRequest request, HttpContext context) -> {
					System.out.println("============ Request =============");
					HttpRequestWrapper requestWrapper = (HttpRequestWrapper) request;
					System.out.println(requestWrapper.getRequestLine());
					for (Header header : request.getAllHeaders()) {
						System.out.println(header.getName() + ": " + header.getValue());
					}
					System.out.println();
				});

				httpClientBuilder.addInterceptorFirst((org.apache.http.HttpResponse response, HttpContext context) -> {
					System.out.println("============ Response ============");
					System.out.println(response.getStatusLine());
					for (Header header : response.getAllHeaders()) {
						System.out.println(header.getName() + ": " + header.getValue());
					}
					System.out.println();
				});
			}
			Unirest.setHttpClient(httpClientBuilder.build());

			initialized = true;
		}
		return new RestClient(baseUrl, apiKey, secretKey);
	}

	public GetRequest get(String path, long customerId) throws SignatureException {
		return withAuthInfo(Unirest.get(baseUrl + path), path, customerId, apiKey, secretKey);
	}

	public HttpRequestWithBody post(String path, long customerId) throws SignatureException {
		HttpRequestWithBody request = Unirest.post(baseUrl + path);
		request.header("Content-Type", "application/json;charset=UTF-8");
		return withAuthInfo(request, path, customerId, apiKey, secretKey);
	}

	public HttpRequestWithBody delete(String path, long customerId) throws SignatureException {
		return withAuthInfo(Unirest.delete(baseUrl + path), path, customerId, apiKey, secretKey);
	}

	public HttpRequestWithBody put(String path, long customerId) throws SignatureException {
		HttpRequestWithBody request = Unirest.put(baseUrl + path);
		request.header("Content-Type", "application/json;charset=UTF-8");
		return withAuthInfo(request, path, customerId, apiKey, secretKey);
	}

	@SuppressWarnings("unchecked")
	private <T extends HttpRequest> T withAuthInfo(T request, String path, long customerId, String apiKey, String secretKey) throws SignatureException {
		String timestamp = String.valueOf(System.currentTimeMillis());

		return (T) request
				.header("X-Timestamp", timestamp)
				.header("X-API-KEY", apiKey)
				.header("X-Customer", String.valueOf(customerId))
				.header("X-Signature", Signatures.of(timestamp, request.getHttpMethod().name(), path, secretKey));
	}

	public <T> T asObject(HttpResponse<String> response, Class<T> type) throws Exception {
		String responseBody = response.getBody();
		if (DEBUG_MODE && responseBody != null) {
			System.out.println(responseBody);
		}

		int status = response.getStatus();
		if (status / 100 != 2) {
			String message = response.getStatus() + " " + response.getStatusText()
					+ ". X-Transaction-ID: " + response.getHeaders().getFirst("X-Transaction-ID")
					+ ", Response Body: " + responseBody;
			throw new Exception(message);
		}
		return responseBody == null ? null : OBJECT_MAPPER.readValue(responseBody, type);
	}

}
