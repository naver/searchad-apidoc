package com.naver.searchad.api.sample;

import com.naver.searchad.api.model.estimate.*;
import com.naver.searchad.api.rest.Estimate;
import com.naver.searchad.api.util.PropertiesLoader;
import com.naver.searchad.api.util.RestClient;

import java.util.Collections;
import java.util.Properties;

public class EstimateSample {

	public static void main(String[] args) {
		try {
			Properties properties = PropertiesLoader.fromResource("sample.properties");
			String baseUrl = properties.getProperty("BASE_URL");
			String apiKey = properties.getProperty("API_KEY");
			String secretKey = properties.getProperty("SECRET_KEY");
			long customerId = Long.parseLong(properties.getProperty("CUSTOMER_ID"));
			RestClient rest = RestClient.of(baseUrl, apiKey, secretKey);

			//#1. estimate bid by average position stats
			RequestAveragePositionBid req = new RequestAveragePositionBid();
			req.setDevice(Device.PC);
			req.setItems(Collections.singletonList(new KeyAndPosition("중고차", 1)));
			ResponseAveragePositionBid res = Estimate.getAveragePositionBid(rest, customerId, IDType.keyword, req);
			System.out.println("res = " + res);
			RequestBidByStatisticsDistribution req2 = new RequestBidByStatisticsDistribution();
			req2.setDevice(Device.PC);
			req2.setPeriod(PeriodType.MONTH);
			req2.setItems(Collections.singletonList("제주여행"));
			ResponseBidByStatisticsDistribution res2 = Estimate.getMedianBid(rest, customerId, IDType.keyword, req2);
			System.out.println("res2 = " + res2);

			RequestBidByStatisticsDistribution req3 = new RequestBidByStatisticsDistribution();
			req3.setDevice(Device.PC);
			req3.setPeriod(PeriodType.MONTH);
			req3.setItems(Collections.singletonList("게스트하우스"));
			ResponseBidByStatisticsDistribution res3 = Estimate.GetExposureMinimumeBid(rest, customerId, IDType.keyword, req3);
			System.out.println("res3 = " + res3);

			RequestPerformance req4 = new RequestPerformance();
			req4.setDevice(Device.PC);
			req4.setKeywordplus(true);
			req4.setKey("발효녹즙");
			req4.setBids(Collections.singletonList(4500));
			ResponsePerformance res4 = Estimate.GetPerformance(rest, customerId, IDType.keyword, req4);
			System.out.println("res4 = " + res4);
			
			RequestPerformanceBulk req5 = new RequestPerformanceBulk();
			req5.setItems(Collections.singletonList(new BulkItem("제주렌트카", 100, false, Device.PC)));
			ResponsePerformanceBulk res5 = Estimate.GetPerformanceBulk(rest, customerId, req5);
			System.out.println("res5 = " + res5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
