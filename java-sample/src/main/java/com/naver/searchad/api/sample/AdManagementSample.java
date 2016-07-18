package com.naver.searchad.api.sample;

import com.naver.searchad.api.model.*;
import com.naver.searchad.api.rest.*;
import com.naver.searchad.api.util.PropertiesLoader;
import com.naver.searchad.api.util.RestClient;
import com.naver.searchad.api.util.Schedules;

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
			
			//캠페인 수정  PUT /ncc/campaigns/{campaignId}{?fields}
			Campaign campaign = campaigns[0];
			campaign.setUserLock(false);
			Campaign updatedCampaign = Campaigns.update(rest, customerId, campaign, "userLock");
			

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
				
				
				//채널생성 POST /ncc/channels
				Channel newChannel = Channels.create(rest, customerId, "API-CHANNEL#" + random.nextInt(1000), "http://www.naver-api"  + random.nextInt(1000) +  ".com");
				
				// 그룹 생성 POST /ncc/adgroups
				adgroup = Adgroups.create(rest, customerId, campaignId, "API-GROUP#" + random.nextInt(1000) + "_" + random.nextInt(1000), channels[0].getNccBusinessChannelId());
				adgroup2 = Adgroups.create(rest, customerId, campaignId, "API-GROUP#" + random.nextInt(1000) + "_" + random.nextInt(1000), newChannel.getNccBusinessChannelId());

				// 그룹 수정 PUT /ncc/adgroups/{adgroupId}{?fields}
				adgroup.setUserLock(false);
				Adgroup updatedAdgroup = Adgroups.update(rest, customerId, adgroup, "userLock");

				String adgroupId = adgroups[0].getNccAdgroupId();
				
				// 타게팅
				TargetSamples(rest, customerId, adgroups[0]);

				// 소재
				AdSamples(rest, customerId, adgroupId, adgroup2.getNccAdgroupId());
				
				//키워드
				AdKeywordSample(rest, customerId, adgroupId);

				// 전화번호 유형의 비즈채널이 존재하는 경우 전화번호 유형의 확장 소재를 등록해볼 수 있다.
				Optional<Channel> phoneChannel = Stream.of(channels).filter(channel -> "PHONE".equals(channel.getChannelTp())).findFirst();

				if (phoneChannel.isPresent()) {
					// 확장 소재
					AdExtensionSample(rest, customerId, adgroupId, phoneChannel.get().getNccBusinessChannelId());
				}

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
		//		},
		//		"mobile":{
		//		"final":"http://m.searchad.naver.com"
		//		},
		//		"headline":"the first line",
		//		"description":"the second line of your ad text"
		//	}
		Map<String, Object> text45_ad = new HashMap<>();
		text45_ad.put("pc", Collections.singletonMap("final", "http://searchad.naver.com"));
		text45_ad.put("mobile", Collections.singletonMap("final", "http://m.searchad.naver.com"));
		text45_ad.put("headline", "the first line");
		text45_ad.put("description", "the second line of your ad text5");

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
		userLockAd.setUserLock(true);

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
					adKeyword.setBidAmt(700L);
					adKeyword.setUseGroupBidAmt(false);
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


		Stream.of(keywords).forEach(keyword -> keyword.setUseGroupBidAmt(true));
		Stream.of(keywords).forEach(keyword -> keyword.setBidAmt(70L));
		Keyword[] updatedKeywordsForBidAmt = Keywords.updateItems(rest, customerId, keywords, "bidAmt");

		// 키워드 수정 PUT /ncc/keywords{?field} bidAmt
		String fields = "bidAmt";
		updatedKeywordsForBidAmt[0].setUseGroupBidAmt(false);
		updatedKeywordsForBidAmt[0].setBidAmt(130L);
		// 키워드 수정 PUT /ncc/keywords/{keywordId}
		Keyword updatedKeyword = Keywords.updateItem(rest, customerId, updatedKeywordsForBidAmt[0], fields);

		keywords = Keywords.listByAdgroupId(rest, customerId, adgroupId);
		String ids = Stream.of(keywords).map(Keyword::getNccKeywordId).collect(Collectors.joining(","));
		Keywords.delete(rest, customerId, ids);
	}

	private static void AdExtensionSample(RestClient rest, long customerId, String ownerId, String channelId) throws Exception {
		// 이 샘플에서는 전화번호 타입의 확장소재에 대해서만 동작한다.
		AdExtension newAdExtension = new AdExtension();
		newAdExtension.setCustomerId(customerId);
		newAdExtension.setOwnerId(ownerId);
		newAdExtension.setType("PHONE");
		newAdExtension.setPcChannelId(channelId);
		newAdExtension.setMobileChannelId(channelId);
		newAdExtension.setSchedule(Schedules.everyDayAndHour());

		// 확장 소재 생성 GET /ncc/ad-extensions{?ownerId}
		AdExtension adExtension = AdExtensions.create(rest, customerId, newAdExtension);

		// 확장 소재 조회 POST /ncc/ad-extensions
		AdExtension[] adExtensions = AdExtensions.listByOwnerId(rest, customerId, ownerId);

		adExtension.setSchedule(
				Schedules.builder()
						.monday(15, 16, 17, 18)
						.tuesday(15, 16, 17)
						.build()
		);

		// 확장 소재 수정 PUT /ncc/ad-extensions/{adExtensionId}{?fields}
		AdExtensions.update(rest, customerId, adExtension.getNccAdExtensionId(), adExtension);

		// 확장 소재 삭제 DELETE /ncc/ad-extensions/{adExtensionId}
		String ids = adExtension.getNccAdExtensionId();
		AdExtensions.delete(rest, customerId, ids);
	}

	private static void TargetSamples(RestClient rest, long customerId, Adgroup adgroup) throws Exception {
		// 타게팅 정보 조회 GET /ncc/adgroups/{adgroupId}/targets
		Map<String, Target> targetMap = Adgroups.targets(rest, customerId, adgroup.getNccAdgroupId());
		for (String targetTp : targetMap.keySet()) {
			System.out.println("## " + targetTp + ": " + targetMap.get(targetTp).getTarget());
		}

		List<Target> targets = new ArrayList<>();

		// 요일/시간대 타게팅
		Target timeTargeting = targetMap.get("TIME_WEEKLY_TARGET");
		timeTargeting.setTarget(
				Schedules.builder()
						.monday(15, 16, 17, 18)
						.tuesday(15, 16, 17)
						.build());

		// 지역 타게팅
		Target regionalTargeting = targetMap.get("REGIONAL_TARGET");
		Map<String, Object> target = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
		map.put("KR", Arrays.asList("09", "07"));
		map.put("OTHERS", Collections.emptyList());
		target.put("location", map);
		regionalTargeting.setTarget(target);

		// 매체 타게팅
		Target mediaTargeting = targetMap.get("MEDIA_TARGET");
		target = new HashMap<>();
		map = new HashMap<>();
		map.put("media", Collections.singletonList(27758L));
		map.put("mediaGroup", Collections.singletonList(1L));
		target.put("type", 3);
		target.put("white", map);
		mediaTargeting.setTarget(target);

		// PC/모바일 타게팅
		Target pcMobileTargeting = targetMap.get("PC_MOBILE_TARGET");
		target = new HashMap<>();
		target.put("pc", true);
		target.put("mobile", false);
		pcMobileTargeting.setTarget(target);

		targets.add(timeTargeting);
		targets.add(regionalTargeting);
		targets.add(mediaTargeting);
		targets.add(pcMobileTargeting);
		adgroup.setTargets(targets);

		Adgroups.update(rest, customerId, adgroup, "targetLocation,targetMedia,targetTime");

		Map<String, Target> updatedTargetMap = Adgroups.targets(rest, customerId, adgroup.getNccAdgroupId());
		for (String targetTp : updatedTargetMap.keySet()) {
			System.out.println("## " + targetTp + ": " + updatedTargetMap.get(targetTp).getTarget());
		}
	}
	
}
