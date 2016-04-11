package com.naver.searchad.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MasterReport {

	String id;
	Item item;
	String fromTime;
	String updateTime;
	Status status;
	String downloadUrl;

	public static enum Item {
		Campaign,
		CampaignBudget,
		BusinessChannel,
		Adgroup,
		AdgroupBudget,
		Keyword,
		Account,
		Ad,
		AdExtension,
		Qi,
		Label,
		LabelRef,
		Media;
	}

	public static enum Status {
		REGIST,
		RUNNING,
		BUILT,
		NONE,
		ERROR;
	}

}
