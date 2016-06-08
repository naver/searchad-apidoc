package com.naver.searchad.api.model;

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
	private Boolean userLock;
	private String deliveryMethod;
	private Boolean useDailyBudget;
	private Long dailyBudget;
	private Boolean usePeriod;
	private Date periodStartDt;
	private Date periodEndDt;
}
