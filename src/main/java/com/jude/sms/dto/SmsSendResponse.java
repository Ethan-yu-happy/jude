package com.jude.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-28 11:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsSendResponse extends SmsResponse{
    /**
     *请求成功 ID
     */
    @NotNull
    private String smsId;
}
