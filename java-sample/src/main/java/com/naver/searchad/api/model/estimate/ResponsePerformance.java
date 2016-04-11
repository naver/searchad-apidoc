package com.naver.searchad.api.model.estimate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePerformance {
	private Device device;
	private Boolean keywordplus;
	private String keyword;
	private String nccKeywordId;
	private List<Performance> estiamte;
}
