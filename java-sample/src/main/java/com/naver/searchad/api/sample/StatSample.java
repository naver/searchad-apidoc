package com.naver.searchad.api.sample;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.naver.searchad.api.model.Stat;
import com.naver.searchad.api.model.Stat.Breakdown;
import com.naver.searchad.api.rest.Stats;
import com.naver.searchad.api.util.PropertiesLoader;
import com.naver.searchad.api.util.RestClient;

public class StatSample {
	public static void main(String[] args) {
		try {

			Properties properties = PropertiesLoader.fromResource("sample.properties");
			String baseUrl = properties.getProperty("BASE_URL");
			String apiKey = properties.getProperty("API_KEY");
			String secretKey = properties.getProperty("SECRET_KEY");
			long customerId = Long.parseLong(properties.getProperty("CUSTOMER_ID"));

			RestClient rest = RestClient.of(baseUrl, apiKey, secretKey);
			
			String id = "cmp-a001-000000000015128";
			List<Stat.Field> fields = Arrays.asList(Stat.Field.impCnt, Stat.Field.clkCnt, Stat.Field.salesAmt, Stat.Field.cpc);			
			
			/*
			 * Retrieving single entity data
			 * 
			 * - dataPreset Usage
			 * - timeRange Usage
			 * - timeIncrement Usage
			 */
			
			// You can receive the daily stat data per single entity with fields(impCnt, clkCnt etc.), datePreset(today, last7days, last30days etc.) parameters.
			Stat.DailyStat dailyStat = Stats.getDailyStatById(rest, customerId, id, fields, null, Stat.DatePreset.last7days, null);
			System.out.println("daily stat : " + dailyStat);
			
			// You can use timeRange parameter, NOT using datePreset.
			// If you use both timeRange and datePreset, datePreset is applied.
			Stat.TimeRange timeRange = new Stat.TimeRange("2016-05-01", "2016-05-10");
			Stat.DailyStat dailyStatWithTimeRange = Stats.getDailyStatById(rest, customerId, id, fields, timeRange, null, null);
			System.out.println("daily stat : " + dailyStatWithTimeRange);
			
			// Also, one can receive the summary stat data per single entity.
			Stat.SummaryStat summaryStat = Stats.getSummaryStatById(rest, customerId, id, fields, null, Stat.DatePreset.last7days, null);
			System.out.println("summary stat : " + summaryStat);
			
			/*
			 * Retrieving detail data
			 * 
			 * You can receive detail data with breakdown parameter.
			 * However, with breakdown parameter, you can retrieve data within maximum last 7 days only.
			 * And breakdown is applied to timeIncrement(allDays), not timeIncrement(1).
			 * 
			 * - breakdown(pcMblTp, dayw, hh24, regnNo) Usage
			 * [Possible combinations of breakdown and field parameter]
			 * 
			 * [breakdown=pcMblTp] impCnt, clkCnt, ctr, cpc, salesAmt, avgRnk, ccnt, recentAvgRnk, recentAvgCpc (recentAvgRnk, recentAvgCpc are applied to ad, keyword entity only) 
			 * [breakdown=hh24] impCnt, clkCnt, ctr, cpc, salesAmt, avgRnk, ccnt
			 * [breakdown=regnNo] impCnt, clkCnt, ctr, cpc, salesAmt, avgRnk, ccnt
			 * [breakdown=dayw] impCnt, clkCnt, ctr, cpc, salesAmt, avgRnk, ccnt
			 * 
			 */
			
			// breakdown parameter is useful when you want to see detail stat data per hour, region etc.
			Stat.SummaryStat summaryStatWithBreakdown = Stats.getSummaryStatById(rest, customerId, id, fields, null, Stat.DatePreset.today, Breakdown.hh24);
			System.out.println("summary stat with breakdown: " + summaryStatWithBreakdown);			
			
			/*
			 * Retrieving multiple entities data
			 * 
			 * You can use ids parameter for retrieving data.
			 * 
			 * - ids Usage
			 */
			
			// Multiple entitis can be used with ids parameter(NOT with id parameter).
			String ids = "cmp-a001-000000000015128,cmp-a001-000000000015163,cmp-a001-000000000015355";
			Stat.SummaryStat summaryStatList = Stats.getSummaryStatByIdList(rest, customerId, ids, fields, null, Stat.DatePreset.last7days, null);
			System.out.println("summary statList: " + summaryStatList);
			
			// Supported breakdown parameter with multiple entitis.
			Stat.SummaryStat summaryStatListWithBreakdown = Stats.getSummaryStatByIdList(rest, customerId, ids, fields, null, Stat.DatePreset.today, Stat.Breakdown.hh24);
			System.out.println("summary statList with breakdown: " + summaryStatListWithBreakdown);

			/*
			 * Advanced retrieving data
			 * 
			 * You can retrieve recentAvgRnk, recentAvgCpc per ad or keyword entity(NOT with campaign, adgroup entity).
			 */
			
			// With breakdown(hh24), datePreset(today)
			id = "nkw-a001-000000000015128";
			fields = Arrays.asList(Stat.Field.impCnt, Stat.Field.clkCnt, Stat.Field.salesAmt, Stat.Field.cpc, Stat.Field.recentAvgCpc, Stat.Field.recentAvgRnk);		
			Stat.SummaryStat hourlyStatData = Stats.getSummaryStatById(rest, customerId, id, fields, null, Stat.DatePreset.today, Breakdown.hh24);
			System.out.println("hourly stat data: " + hourlyStatData);
			
			// As you know, since it is not predictable whether recentAvgRnk or recentAvgCpc is exists or not, you can write code like this.
			final int retryIntervalInMinutes = 30;
			
			for(int i = 0; i <= 3; i++) {
				System.out.println("check recentAvgCpc...");
				hourlyStatData = Stats.getSummaryStatById(rest, customerId, id, fields, null, Stat.DatePreset.today, Breakdown.hh24);
				Double recentAvgCpc = hourlyStatData.getData().get(0).getRecentAvgCpc();
				if (null != recentAvgCpc) {
					System.out.println("recentAvgCpc : " + recentAvgCpc);
					break;
				}
				TimeUnit.MINUTES.sleep(retryIntervalInMinutes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
