package com.naver.searchad.api.rest;


import com.mashape.unirest.http.HttpResponse;
import com.naver.searchad.api.model.Ad;
import com.naver.searchad.api.model.UserLock;
import com.naver.searchad.api.util.RestClient;

public class Ads {

	/*
	소재 목록 조회 GET /ncc/ads{?nccAdgroupId}
	소재 복사 PUT /ncc/ads{?ids,targetAdgroupId,userLock}
	소재 생성 POST /ncc/ads
	소재 수정 PUT /ncc/ads/{adId}{?fields}
	소재 삭제 DELETE /ncc/ads/{adId}
	 */
	static String adsPath = "/ncc/ads";

	public static Ad[] listByAdgroupId(RestClient rest, String adgroupId, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.get(adsPath, customerId)
						.queryString("nccAdgroupId", adgroupId)
						.asString();
		return rest.asObject(response, Ad[].class);
	}

	public static Ad get(RestClient rest, String adId, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.get(adsPath + "/" + adId, customerId)
						.asString();
		return rest.asObject(response, Ad.class);
	}

	// pathId, queryParam, body, apiKey
	public static Ad update(RestClient rest, String adId, String fields, Ad ad, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.put(adsPath + "/" + adId, customerId)
						.queryString("fields", fields)
						.body(ad)
						.asString();
		return rest.asObject(response, Ad.class);
	}

	public static Ad[] copy(RestClient rest, String ids, String targetAdgroupId, UserLock userLock, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.put(adsPath, customerId)
						.queryString("ids", ids)
						.queryString("targetAdgroupId", targetAdgroupId)
						.queryString("userLock", userLock.getValue())
						.asString();
		return rest.asObject(response, Ad[].class);
	}

	public static Ad create(RestClient rest, Ad ad, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.post(adsPath, customerId)
						.body(ad)
						.asString();
		return rest.asObject(response, Ad.class);
	}

	public static void delete(RestClient rest, String adId, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.delete(adsPath + "/" + adId, customerId)
						.asString();
		rest.asObject(response, String.class);
	}

}
