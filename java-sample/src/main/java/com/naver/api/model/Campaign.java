package com.naver.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Campaign {
	private String nccCampaignId;
	private String campaignTp;
	private Long customerId;
	private String name;
	private UserLock userLock;
	private Integer deliveryMethod;
	private Integer useDailyBudget;
	private Long dailyBudget;
	private Integer usePeriod;
	private Date periodStartDt;
	private Date periodEndDt;
}
