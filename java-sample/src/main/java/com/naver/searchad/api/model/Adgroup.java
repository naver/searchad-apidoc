package com.naver.searchad.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Adgroup {
	private String nccAdgroupId;
	private Long customerId;
	private String nccCampaignId;
	private String mobileChannelId;
	private String pcChannelId;
	private Integer bidAmt;
	private String name;
	private Boolean userLock;
	private Boolean useDailyBudget;
	private Boolean useKeywordPlus;
	private Integer keywordPlusWeight;
	private Integer contentsNetworkBidAmt;
	private Boolean useCntsNetworkBidAmt;
	private Long mobileNetworkBidWeight;
	private Long pcNetworkBidWeight;
	private Long dailyBudget;
	private Date regTm;
	private Date editTm;
	private List<Target> targets;
	private String status;
	private String statusReason;
}
