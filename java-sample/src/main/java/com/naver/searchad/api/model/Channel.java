package com.naver.searchad.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Channel {
	private String nccBusinessChannelId;
	private Long customerId;
	private String channelTp;
	private String name;
	private Map<String, Object> businessInfo;
	private String pcInspectStatus;
	private String mobileInspectStatus;
	private String adultStatus;
	private String blackStatus;
	private Boolean enabled;
}
