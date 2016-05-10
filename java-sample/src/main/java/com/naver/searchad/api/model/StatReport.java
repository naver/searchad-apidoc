package com.naver.searchad.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatReport {
	private Long reportJobId;
	private String reportTp;
	private String status;
	private String downloadUrl;
	private String statDt;
	private String updateTm;
}
