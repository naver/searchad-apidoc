package com.naver.searchad.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.searchad.api.model.StatReport;
import com.naver.searchad.api.util.RestClient;

public class StatReports {

	/*
	 * 리포트 요청 POST /stat-reports 리포트 조회 GET /stat-reports/{reportJobId}
	 */

	// create
	public static StatReport create(RestClient rest, long customerId, String reportType, String statDate) throws Exception {
		HttpResponse<String> response = rest.post("/stat-reports", customerId)
				.header("Content-Type", "application/json")
				.body("{\"reportTp\":\"" + reportType + "\", \"statDt\":\"" + statDate + "\"}")
				.asString();

		return rest.asObject(response, StatReport.class);
	}

	// get
	public static StatReport get(RestClient rest, long customerId, long reportJobId) throws Exception {
		HttpResponse<String> response = rest.get("/stat-reports/" + reportJobId, customerId)
				.asString();

		return rest.asObject(response, StatReport.class);
	}

}
