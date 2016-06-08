package com.naver.searchad.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdExtension {
    private String nccAdExtensionId;
    private String ownerId;
    private long customerId;
    private String inspectStatus;
    private String type;
    private Map<String, Object> schedule;
    private String pcChannelId;
    private String mobileChannelId;
    private Date regTm;
    private Date editTm;
    private Boolean userLock;
    private String status;
    private String statusReason;
}
