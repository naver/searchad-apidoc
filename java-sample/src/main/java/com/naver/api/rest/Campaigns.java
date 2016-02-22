package com.naver.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.api.model.Campaign;
import com.naver.api.util.RestClient;

public class Campaigns {

	public static Campaign[] list(RestClient rest, long customerId) throws Exception {
		String path = "/ncc/campaigns";
		HttpResponse<String> response = rest.get(path, customerId).asString();

		return rest.asObject(response, Campaign[].class);
	}

}
