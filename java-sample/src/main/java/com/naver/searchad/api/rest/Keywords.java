package com.naver.searchad.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.searchad.api.model.Keyword;
import com.naver.searchad.api.util.RestClient;

public class Keywords {
	/*
	키워드 목록 조회 GET /ncc/keywords{?nccAdgroupId}
	키워드 생성 GET /ncc/keywords{?nccAdgroupId}
	키워드 수정 GET /ncc/keywords{?nccAdgroupId}
	  */
	static String keywordsPath = "/ncc/keywords";

	public static Keyword[] listByAdgroupId(RestClient rest, long customerId, String adgroupId) throws Exception {
		HttpResponse<String> response =
				rest.get(keywordsPath, customerId)
						.queryString("nccAdgroupId", adgroupId)
						.asString();
		return rest.asObject(response, Keyword[].class);
	}

	public static Keyword[] create(RestClient rest, long customerId, String adgroupId, Keyword[] keywords) throws Exception {
		HttpResponse<String> response =
				rest.post(keywordsPath, customerId)
						.queryString("nccAdgroupId", adgroupId)
						.body(keywords)
						.asString();
		return rest.asObject(response, Keyword[].class);
	}

	public static Keyword[] updateItems(RestClient rest, long customerId, Keyword[] keywords, String fields) throws Exception {
		HttpResponse<String> response =
				rest.put(keywordsPath, customerId)
						.queryString("fields", fields)
						.body(keywords)
						.asString();
		return rest.asObject(response, Keyword[].class);
	}

	public static Keyword updateItem(RestClient rest, long customerId, Keyword keyword, String fields) throws Exception {
		HttpResponse<String> response =
				rest.put(keywordsPath + "/" + keyword.getNccKeywordId(), customerId)
						.queryString("fields", fields)
						.body(keyword)
						.asString();
		return rest.asObject(response, Keyword.class);
	}

	public static Keyword delete(RestClient rest, long customerId, String ids) throws Exception {
		HttpResponse<String> response =
				rest.delete(keywordsPath, customerId)
						.queryString("ids", ids)
						.asString();
		return rest.asObject(response, Keyword.class);
	}


}
