package com.naver.searchad.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ad {
	private String nccAdId;
	private String nccAdgroupId;
	private Long customerId;
	private InspectStatus inspectStatus;
	private String type;
	private Map<String, Object> ad;
	private Boolean userLock;
	private String inspectRequestMsg;
}
