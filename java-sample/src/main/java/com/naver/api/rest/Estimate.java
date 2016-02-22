package com.naver.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.api.model.estimate.*;
import com.naver.api.util.RestClient;

public class Estimate {
	public static ResponseAveragePositionBid getAveragePositionBid(RestClient rest, long customerId, IDType type, RequestAveragePositionBid req) throws Exception {
		HttpResponse<String> response =
				rest.post("/estimate/average-position-bid/" + type, customerId)
						.body(req)
						.asString();
		return rest.asObject(response, ResponseAveragePositionBid.class);
	}

	public static ResponseBidByStatisticsDistribution getMedianBid(RestClient rest, long customerId, IDType type, RequestBidByStatisticsDistribution req) throws Exception {
		HttpResponse<String> response =
				rest.post("/estimate/median-bid/" + type, customerId)
						.body(req)
						.asString();
		return rest.asObject(response, ResponseBidByStatisticsDistribution.class);
	}

	public static ResponseBidByStatisticsDistribution GetFirstPageBid(RestClient rest, long customerId, IDType type, RequestBidByStatisticsDistribution req) throws Exception {
		HttpResponse<String> response =
				rest.post("/estimate/first-page-bid/" + type, customerId)
						.body(req)
						.asString();
		return rest.asObject(response, ResponseBidByStatisticsDistribution.class);
	}

	public static ResponsePerformance GetPerformance(RestClient rest, long customerId, IDType type, RequestPerformance req) throws Exception {
		HttpResponse<String> response =
				rest.post("/estimate/performance/" + type, customerId)
						.body(req)
						.asString();
		return rest.asObject(response, ResponsePerformance.class);
	}
}
