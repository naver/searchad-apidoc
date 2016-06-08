package com.naver.searchad.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.searchad.api.model.Campaign;
import com.naver.searchad.api.util.RestClient;

public class Campaigns {

	public static Campaign[] list(RestClient rest, long customerId) throws Exception {
		String path = "/ncc/campaigns";
		HttpResponse<String> response = rest.get(path, customerId).asString();

		return rest.asObject(response, Campaign[].class);
	}
	
	public static Campaign update(RestClient rest, long customerId, Campaign campaign, String fields) throws Exception {
		String path = "/ncc/campaigns";
		
		HttpResponse<String> response =
				rest.put(path + "/" + campaign.getNccCampaignId(), customerId)
						.queryString("fields", fields)
						.body(campaign)
						.asString();
		return rest.asObject(response, Campaign.class);
	}
	
	

}
