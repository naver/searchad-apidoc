package com.naver.searchad.api.model.estimate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstiamteBidByPosition {
	private String keyword;
	private Integer position;
	private String nccKeywordId;
	private Integer bid;
}
