package com.naver.api.sample;

import com.naver.api.model.*;
import com.naver.api.rest.*;
import com.naver.api.util.PropertiesLoader;
import com.naver.api.util.RestClient;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdManagementSample {

	public static void main(String[] args) {
		try {
			Properties properties = PropertiesLoader.fromResource("sample.properties");
			String baseUrl = properties.getProperty("BASE_URL");
			String apiKey = properties.getProperty("API_KEY");
			String secretKey = properties.getProperty("SECRET_KEY");
			long managerCustomerId = Long.parseLong(properties.getProperty("CUSTOMER_ID"));

			RestClient rest = RestClient.of(baseUrl, apiKey, secretKey);

			// 권한 조회
			CustomerLink[] customerLinks = CustomerLinks.list(rest, managerCustomerId, "MYCLIENTS");

			// 캠페인 목록 조회 GET /ncc/campaigns
			long customerId = customerLinks[0].getClientCustomerId();
			Campaign[] campaigns = Campaigns.list(rest, customerId);

			// 비즈 채널 목록 조회 GET /ncc/channels
			Channel[] channels = Channels.list(rest, customerId);
			System.out.println("***********************************");
			System.out.println(channels.length);

			// 그룹 목록 조회 GET /ncc/adgroups{?nccCampaignId}
			String campaignId = campaigns[0].getNccCampaignId();
			Adgroup[] adgroups = Adgroups.listByCampaignId(rest, customerId, campaignId);

			Adgroup adgroup = null;
			Adgroup adgroup2 = null;
			try {
				Random random = new Random();

				// 그룹 생성 POST /ncc/adgroups
				adgroup = Adgroups.create(rest, customerId, campaignId, "API-GROUP#" + random.nextInt(1000) + "_" + random.nextInt(1000), channels[0].getNccBusinessChannelId());
				adgroup2 = Adgroups.create(rest, customerId, campaignId, "API-GROUP#" + random.nextInt(1000) + "_" + +random.nextInt(1000), channels[0].getNccBusinessChannelId());

				// 그룹 수정 PUT /ncc/adgroups/{adgroupId}{?fields}
				adgroup.setUserLock(UserLock.PAUSED);
				Adgroup[] updatedAdgroup = Adgroups.update(rest, customerId, adgroup, "userLock");

				String adgroupId = adgroups[0].getNccAdgroupId();

				//키워드
				AdKeywordSample(rest, customerId, adgroupId);

				// 소재
				AdSamples(rest, customerId, adgroupId, adgroup2.getNccAdgroupId());
			} finally {
				if (adgroup != null) {
					Adgroups.delete(rest, customerId, adgroup.getNccAdgroupId());
				}
				if (adgroup2 != null) {
					Adgroups.delete(rest, customerId, adgroup2.getNccAdgroupId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void AdSamples(RestClient rest, Long customerId, String adgroupId, String targetAdgroupId) throws Exception {
		String adType = "TEXT_45";
		String adId = null;

		// Create an ad : POST /ncc/ads /////////////////////////////////////////////////////

		//	{
		//		"pc":{
		//		"final":"http://searchad.naver.com"
		//	},
		//		"mobile":{
		//		"final":"http://m.searchad.naver.com"
		//	},
		//		"headline":"the first line",
		//			"description":"the second line of your ad text"
		//	}
		Map<String, Object> text45_ad = new HashMap<>();
		text45_ad.put("pc", Collections.singletonMap("final", "http://searchad.naver.com"));
		text45_ad.put("mobile", Collections.singletonMap("final", "http://m.searchad.naver.com"));
		text45_ad.put("headline", "the first line");
		text45_ad.put("description", "the second line of your ad text4");

		Ad createAd = new Ad();
		createAd.setCustomerId(customerId);
		createAd.setNccAdgroupId(adgroupId);
		createAd.setType(adType);
		createAd.setAd(text45_ad);

		Ad createdAd = Ads.create(rest, createAd, customerId);
		if (createdAd == null) {
			throw new Exception("POST /ncc/ads");
		}
		adId = createdAd.getNccAdId();
		System.out.println("create: " + createdAd.toString());
		////////////////////////////////////////////////////////////////////////////////////

		// Get the ads of an adgroup : GET /ncc/ads{?nccAdgroupId} /////////////////////////
		Ad[] ads = Ads.listByAdgroupId(rest, adgroupId, customerId);
		if (ads == null) {
			throw new Exception("GET /ncc/ads{?nccAdgroupId}");
		}
		System.out.println("listByAdgroupId: " + ads.toString());
		///////////////////////////////////////////////////////////////////////////////////

		// Get an ad: GET /ncc/ads/{adId} /////////////////////////////////////////////////
		Ad gettedAd = Ads.get(rest, adId, customerId);
		if (gettedAd == null) {
			throw new Exception("GET /ncc/ads/{adId}");
		}
		System.out.println("get: " + gettedAd.toString());
		///////////////////////////////////////////////////////////////////////////////////


		// Update an ad: PUT /ncc/ads/{adId}{?fields} ////////////////////////////////////
		// update the userLock
		String fields = "userLock";

		Ad userLockAd = new Ad();
		userLockAd.setNccAdId(adId);
		userLockAd.setUserLock(UserLock.PAUSED);

		Ad updatedAd = Ads.update(rest, adId, fields, userLockAd, customerId);
		if (updatedAd == null) {
			throw new Exception("PUT /ncc/ads/{adId}{?fields=userLock}");
		}
		System.out.println("update(userLock): " + updatedAd.toString());

		// requiring inspect. It works when ad.getInspectStatus() is 30.
//		fields = "inspect";
//		String inspectRequestMsg = "Check my ad text again, please. I added the document.";
//
//		Ad inspectAd = new Ad();
//		inspectAd.setNccAdId(adId);
//		inspectAd.setInspectRequestMsg(inspectRequestMsg);
//		updatedAd = Ads.update(rest, adId, fields, inspectAd, customerId);
//		if (updatedAd == null) {
//			throw new Exception("PUT /ncc/ads/{adId}{?fields=inspect}");
//		}
//		System.out.println("update(inspect): " + updatedAd.toString());
//
//		// update the userLock and the requiring inspect together.
//		fields = "userLock,inspect";
//		inspectRequestMsg = "Another messages.";
//		inspectAd.setInspectRequestMsg(inspectRequestMsg);
//		inspectAd.setUserLock(UserLock.PAUSED);
//		updatedAd = Ads.update(rest, adId, fields, inspectAd, customerId);
//		if (updatedAd == null) {
//			throw new Exception("PUT /ncc/ads/{adId}{?fields=userLock,inspect}");
//
//		}
//		System.out.println("update(userLock,inspect): " + updatedAd.toString());
		////////////////////////////////////////////////////////////////////////////////////

		// Copy some ads to an adgroup: PUT /ncc/ads{?ids,targetAdgroupId,userLock} ///////
		String ids = null;    // get adIds from the ads
		for (int i = 0, n = ads.length; i < n; ++i) {
			if (ids != null) {
				ids += "," + ads[i].getNccAdId();
			}
		}

		Ad[] copiedAds = Ads.copy(rest, ids, targetAdgroupId, UserLock.ENABLED, customerId);
		if (copiedAds == null) {
			throw new Exception("PUT /ncc/ads{?ids,targetAdgroupId,userLock}");
		}
		System.out.println("copiedAds: " + copiedAds.toString());
		///////////////////////////////////////////////////////////////////////////////////


		// delete a ad: DELETE /ncc/ads/{adId} /////////////////////////////////////////
		Ads.delete(rest, createdAd.getNccAdId(), customerId);
		System.out.println("DELETE Ad done.");
		///////////////////////////////////////////////////////////////////////////////////
	}

	private static void AdKeywordSample(RestClient rest, long customerId, String adgroupId) throws Exception {
		// if keyword are duplicated then return resultStatus
		List<Keyword> keywordList = Stream.of("테스트", "테스트", "키워드", "AdKeyword")
				.map(keyword -> {
					Keyword adKeyword = new Keyword();
					adKeyword.setKeyword(keyword);
					return adKeyword;
				}).collect(Collectors.toList());

		// 키워드 생성 GET /ncc/keywords{?nccAdgroupId}
		Keyword[] createdKeyword = Keywords.create(rest, customerId, adgroupId, keywordList.toArray(new Keyword[keywordList.size()]));

		// 키워드 목록 조회 GET /ncc/keywords{?nccAdgroupId}
		Keyword[] keywords = Keywords.listByAdgroupId(rest, customerId, adgroupId);

		Map<String, Object> links = new HashMap<>();
		links.put("pc", Collections.singletonMap("final", "http://searchad.naver.com"));
		links.put("mobile", Collections.singletonMap("final", "http://m.searchad.naver.com"));

		Stream.of(keywords).forEach(keyword -> keyword.setLinks(links));

		// 키워드 수정 PUT /ncc/keywords{?field} Links

		Keyword[] updatedKeywordsForLinks = Keywords.updateItems(rest, customerId, keywords, "links");

		Stream.of(keywords).forEach(keyword -> keyword.setBidAmt(1000L));
		Keyword[] updatedKeywordsForBidAmt = Keywords.updateItems(rest, customerId, keywords, "bidAmt");

		// 키워드 수정 PUT /ncc/keywords{?field} bidAmt
		String fields = "bidAmt";
		updatedKeywordsForBidAmt[0].setBidAmt(130L);

		// 키워드 수정 PUT /ncc/keywords/{keywordId}
		Keyword updatedKeyword = Keywords.updateItem(rest, customerId, updatedKeywordsForBidAmt[0], fields);

		keywords = Keywords.listByAdgroupId(rest, customerId, adgroupId);
		String ids = Stream.of(keywords).map(Keyword::getNccKeywordId).collect(Collectors.joining(","));
		Keywords.delete(rest, customerId, ids);
	}

}
