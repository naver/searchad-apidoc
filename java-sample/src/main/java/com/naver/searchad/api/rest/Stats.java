package com.naver.searchad.api.rest;

import java.util.List;

import com.mashape.unirest.request.HttpRequest;
import com.naver.searchad.api.model.Stat;
import com.naver.searchad.api.model.Stat.Breakdown;
import com.naver.searchad.api.model.Stat.TimeIncrement;
import com.naver.searchad.api.util.RestClient;

public class Stats {
	// Receive the daily report per single entity
	public static Stat.DailyStat getDailyStatById(RestClient rest, long customerId, String id, List<Stat.Field> fields,
			Stat.TimeRange timeRange, Stat.DatePreset datePreset, Breakdown breakdown) throws Exception {

		HttpRequest request = rest.get("/stats", customerId).queryString("id", id)
				.queryString("fields", fields.toString())
				.queryString("timeIncrement", TimeIncrement.daily.getValue());

		if (null != datePreset) {
			request.queryString("datePreset", datePreset.getValue());
		}

		if (null != timeRange) {
			request.queryString("timeRange", timeRange.toString());
		}

		if (null != breakdown) {
			request.queryString("breakdown", breakdown.getValue());
		}

		return rest.asObject(request.asString(), Stat.DailyStat.class);
	}

	// Receive the summary report per single entity
	public static Stat.SummaryStat getSummaryStatById(RestClient rest, long customerId, String id,
			List<Stat.Field> fields, Stat.TimeRange timeRange, Stat.DatePreset datePreset, Breakdown breakdown)
					throws Exception {

		HttpRequest request = rest.get("/stats", customerId).queryString("id", id)
				.queryString("fields", fields.toString())
				.queryString("timeIncrement", TimeIncrement.summary.getValue());

		if (null != datePreset) {
			request.queryString("datePreset", datePreset.getValue());
		}

		if (null != timeRange) {
			request.queryString("timeRange", timeRange.toString());
		}

		if (null != breakdown) {
			request.queryString("breakdown", breakdown.getValue());
		}

		return rest.asObject(request.asString(), Stat.SummaryStat.class);
	}

	// Receive the summary report per multiple entities
	public static Stat.SummaryStat getSummaryStatByIdList(RestClient rest, long customerId, String ids,
			List<Stat.Field> fields, Stat.TimeRange timeRange, Stat.DatePreset datePreset, Breakdown breakdown)
					throws Exception {

		HttpRequest request = rest.get("/stats", customerId).queryString("ids", ids)
				.queryString("fields", fields.toString())
				.queryString("timeIncrement", TimeIncrement.summary.getValue());

		if (null != datePreset) {
			request.queryString("datePreset", datePreset.getValue());
		}

		if (null != timeRange) {
			request.queryString("timeRange", timeRange.toString());
		}

		if (null != breakdown) {
			request.queryString("breakdown", breakdown.getValue());
		}

		return rest.asObject(request.asString(), Stat.SummaryStat.class);
	}
}
