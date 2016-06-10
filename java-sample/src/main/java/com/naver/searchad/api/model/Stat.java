package com.naver.searchad.api.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stat {
	private DailyStat dailyStat;
	private SummaryStat summaryStat;

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class DailyStat {
		private Summary summary;
		private List<DailyStatData> data;
	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class SummaryStat {
		private List<SummaryStatData> data;
	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class DailyStatData {
		private String dateStart;
		private String dateEnd;
		private Integer impCnt;
		private Integer clkCnt;
		private Integer salesAmt;
		private Integer ccnt;
		private Integer cpc;
		private Double avgRnk;
		private Double crto;
		private Double ctr;
		private Double drtCrto;
		private Double recentAvgCpc;
		private Double recentAvgRnk;
	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class SummaryStatData {
		private List<BreakdownStat> breakdowns;
		private String id;
		private Integer impCnt;
		private Integer clkCnt;
		private Integer salesAmt;
		private Integer ccnt;
		private Integer cpc;
		private Double avgRnk;
		private Double crto;
		private Double ctr;
		private Double drtCrto;
		private Double recentAvgCpc;
		private Double recentAvgRnk;

	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class BreakdownStat {
		private String name;
		private Integer impCnt;
		private Integer clkCnt;
		private Integer salesAmt;
		private Integer ccnt;
		private Integer cpc;
		private Double avgRnk;
		private Double crto;
		private Double ctr;
		private Double drtCrto;
		private Double recentAvgCpc;
		private Double recentAvgRnk;
	}
	
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class TimeRange {
		private String since;
		private String until;
		
		public TimeRange(String since, String until) {
			this.since = since;
			this.until = until;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("{\"since\":").append("\"").append(since).append("\"").append(",")
			.append("\"until\":").append("\"").append(until).append("\"").append("}");
			
			return sb.toString();
		}
	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class Summary {
		private String dateStart;
		private String dateEnd;
	}

	public static enum Field {
		impCnt("impCnt")	// impression count
		, clkCnt("clkCnt")	// click count
		, ctr("ctr")		// clickthrough rate
		, cpc("cpc")		// cost per click
		, avgRnk("avgRnk")	// average rank
		, ccnt("ccnt")		// conversion count
		, salesAmt("salesAmt")	// sales amount
		, recentAvgCpc("recentAvgCpc") // recent average cpc 
		, recentAvgRnk("recentAvgRnk") //recent average rank
		, drtCrto("drtCrto"); // direct conversion ratio

		@Getter private final String value;

		private Field(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("\"");
			sb.append(value).append("\"");
			
			return sb.toString();
		}
	}

	public static enum DatePreset {
		today("today")
		, yesterday("yesterday")
		, last7days("last7days")
		, last30days("last30days")
		, lastweek("lastweek")
		, lastmonth("lastmonth")
		, lastquarter("lastquarter");

		@Getter private final String value;

		private DatePreset(String value) {
			this.value = value;
		}
	}

	public static enum TimeIncrement {
		daily("1")
		, summary("allDays");

		@Getter private final String value;

		private TimeIncrement(String value) {
			this.value = value;
		}
	}

	public static enum Breakdown {
		pcMblTp("pcMblTp")
		, dayw("dayw")
		, hh24("hh24")
		, regnNo("regnNo");

		@Getter private final String value;

		private Breakdown(String value) {
			this.value = value;
		}
	}

}
