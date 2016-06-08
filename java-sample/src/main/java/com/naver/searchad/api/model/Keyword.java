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
	private Boolean userLock;
	private InspectStatus inspectStatus;
	private Long bidAmt;
	private Boolean useGroupBidAmt;
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
	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class ManagedKeyword {
		private String keyword;
		private Boolean isAdult;
		private Boolean isBrand;
		private Boolean isRestricted;
		private Boolean isSeason;
		private Boolean isSellProhibit;
		private Boolean isShoppingMall;
		private Boolean isLowSearchVolume;
		private Integer pCPLMaxDepth;
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
