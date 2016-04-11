package com.naver.searchad.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.searchad.api.model.Channel;
import com.naver.searchad.api.util.RestClient;

import java.util.HashMap;
import java.util.Map;

public class Channels {

	private static String apiPath = "/ncc/channels";

	public static Channel create(RestClient rest, long customerId, String campaignId, String name, String channelId) throws Exception {
		Channel channel = new Channel();
		channel.setCustomerId(customerId);
		channel.setName(name);
		channel.setChannelTp("SITE");
		Map<String, Object> bi = new HashMap<>();
		bi.put("site", "http://api.searchad.naver.com");
		channel.setBusinessInfo(bi);

		HttpResponse<String> response = rest.post(apiPath, customerId).body(channel).asString();
		return rest.asObject(response, Channel.class);
	}

	public static Channel[] list(RestClient rest, long customerId) throws Exception {
		HttpResponse<String> response = rest.get(apiPath, customerId).asString();
		return rest.asObject(response, Channel[].class);
	}

}
