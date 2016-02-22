package com.naver.api.model;

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
	private UserLock userLock;
	private Integer useDailyBudget;
	private Integer useKeywordPlus;
	private Integer keywordPlusWeight;
	private Integer contentsNetworkBidAmt;
	private Integer useCntsNetworkBidAmt;
	private Long mobileNetworkBidWeight;
	private Long pcNetworkBidWeight;
	private Long dailyBudget;
	private Date regTm;
	private Date editTm;
	private List<Target> targets;
	private String status;
	private String statusReason;
}
