package com.jude.sms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 15:47
 */
@Data
public class SmsSignCodeCreateData {
    /**
     * 签名
     */
    @NotNull
    private String sign ;

    /**
     * 签名子码
     */
    @NotNull
    private String  customerExpandSubCode;
}
