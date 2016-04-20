package com.naver.searchad.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.searchad.api.model.AdExtension;
import com.naver.searchad.api.util.RestClient;

public class AdExtensions {
    /*
    확장 소재 목록 조회 GET /ncc/ad-extensions{?ownerId}
    확장 소재 생성 POST /ncc/ad-extensions
    확장 소재 수정 PUT /ncc/ad-extensions/{adExtensionId}{?fields}
    확장 소재 삭제 DELETE /ncc/ad-extensions/{adExtensionId}
	 */

	private static final String AD_EXTENSIONS_PATH = "/ncc/ad-extensions";

	public static AdExtension[] listByOwnerId(RestClient rest, long customerId, String ownerId) throws Exception {
		HttpResponse<String> response =
				rest.get(AD_EXTENSIONS_PATH, customerId)
						.queryString("ownerId", ownerId)
						.asString();
		return rest.asObject(response, AdExtension[].class);
	}

	public static AdExtension create(RestClient rest, long customerId, AdExtension adExtension) throws Exception {
		HttpResponse<String> response =
				rest.post(AD_EXTENSIONS_PATH, customerId)
						.body(adExtension)
						.asString();

		return rest.asObject(response, AdExtension.class);
	}

	public static AdExtension update(RestClient rest, long customerId, String adExtensionId, AdExtension adExtension) throws Exception {
		HttpResponse<String> response =
				rest.put(AD_EXTENSIONS_PATH + "/" + adExtensionId, customerId)
						.body(adExtension)
						.asString();

		return rest.asObject(response, AdExtension.class);
	}

	public static void delete(RestClient rest, long customerId, String ids) throws Exception {
		HttpResponse<String> response =
				rest.delete(AD_EXTENSIONS_PATH, customerId)
						.queryString("ids", ids)
						.asString();

		rest.asObject(response, String.class);
	}

}
