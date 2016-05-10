package com.naver.searchad.api.sample;

import com.naver.searchad.api.model.StatReport;
import com.naver.searchad.api.rest.StatReports;
import com.naver.searchad.api.util.PropertiesLoader;
import com.naver.searchad.api.util.RestClient;

import java.util.Properties;

public class StatReportSample {

	public static void main(String[] args) {
		try {

			Properties properties = PropertiesLoader.fromResource("sample.properties");
			String baseUrl = properties.getProperty("BASE_URL");
			String apiKey = properties.getProperty("API_KEY");
			String secretKey = properties.getProperty("SECRET_KEY");
			long customerId = Long.parseLong(properties.getProperty("CUSTOMER_ID"));

			RestClient rest = RestClient.of(baseUrl, apiKey, secretKey);

			String reportType = "AD";
			String statDate = "20160201";

			// 리포트 요청 POST /stat-reports
			StatReport statReport = StatReports.create(rest, customerId, reportType, statDate);
			long reportJobId = statReport.getReportJobId();

			// 리포트 조회 GET /stat-reports/{reportJobId}
			StatReport singleStatReport = StatReports.get(rest, customerId, reportJobId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
