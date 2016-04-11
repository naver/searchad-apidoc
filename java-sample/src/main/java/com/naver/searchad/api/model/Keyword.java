package com.naver.searchad.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Keyword {
	private String nccKeywordId;
	private String keyword;
	private Long customerId;
	private String nccAdgroupId;
	private String nccCampaignId;
	private Map<String, Object> links;
	private Integer userLock;
	private Integer inspectStatus;
	private Long bidAmt;
	private Integer useGroupBidAmt;
	private Date regTm;
	private Date editTm;
	private String status;
	private String statusReason;
	private NccQi nccQi;
	private ManagedKeyword managedKeyword;
	private ResultStatus resultStatus;

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class NccQi {
		private Integer qiGrade;
		private String nccAdgroupId;
	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class ManagedKeyword {
		private String keyword;
		private Integer isAdult;
		private Integer isBrand;
		private Integer isRestricted;
		private Integer isSeason;
		private Integer isSellProhibit;
		private Integer isShoppingMall;
		private Integer isLowSearchVolume;
		private Date regTm;
		private Date editTm;
	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class ResultStatus {
		private Integer code;
		private String message;
	}

}
