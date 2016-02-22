package com.naver.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.api.model.CustomerLink;
import com.naver.api.util.RestClient;

public class CustomerLinks {

	public static CustomerLink[] list(RestClient rest, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.get("/customer-links", customerId)
						.asString();

		return rest.asObject(response, CustomerLink[].class);
	}

	public static CustomerLink[] list(RestClient rest, long customerId, String type) throws Exception {
		HttpResponse<String> response =
				rest.get("/customer-links", customerId)
						.queryString("type", type)
						.asString();

		return rest.asObject(response, CustomerLink[].class);
	}

}
