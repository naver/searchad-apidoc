package com.naver.searchad.api.rest;

import com.mashape.unirest.http.HttpResponse;
import com.naver.searchad.api.model.MasterReport;
import com.naver.searchad.api.util.RestClient;

public class MasterReports {
	public static MasterReport CreateDeltaMasterReportJob(RestClient rest, long customerId, MasterReport.Item item, String fromTime) throws Exception {
		MasterReport job = new MasterReport();
		job.setItem(item);
		job.setFromTime(fromTime);
		HttpResponse<String> response =
				rest.post("/master-reports", customerId)
						.body(job)
						.asString();
		return rest.asObject(response, MasterReport.class);
	}

	public static MasterReport CreateFullMasterReportJob(RestClient rest, long customerId, MasterReport.Item item) throws Exception {
		MasterReport job = new MasterReport();
		job.setItem(item);
		HttpResponse<String> response =
				rest.post("/master-reports", customerId)
						.body(job)
						.asString();
		return rest.asObject(response, MasterReport.class);
	}

	public static MasterReport[] GetListOfMasterReportJobs(RestClient rest, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.get("/master-reports", customerId)
						.asString();
		return rest.asObject(response, MasterReport[].class);
	}

	public static MasterReport GetMasterReportJob(RestClient rest, long customerId, String id) throws Exception {
		HttpResponse<String> response =
				rest.get("/master-reports/" + id, customerId)
						.asString();
		return rest.asObject(response, MasterReport.class);
	}

	public static String DeleteAllMasterReportJobs(RestClient rest, long customerId) throws Exception {
		HttpResponse<String> response =
				rest.delete("/master-reports", customerId)
						.asString();
		return rest.asObject(response, String.class);
	}

	public static String DeleteMasterReportJob(RestClient rest, long customerId, String id) throws Exception {
		HttpResponse<String> response =
				rest.delete("/master-reports/" + id, customerId)
						.asString();
		return rest.asObject(response, String.class);
	}
}
