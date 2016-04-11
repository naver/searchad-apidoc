package com.naver.searchad.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Target {
	private String nccTargetId;
	private String nccAdgroupId;
	private Integer targetTp;
	private String target;
	private Date regTm;
	private Date editTm;
}
