package com.jude.sms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 15:00
 */
@Data
public class SmsSignRecord {

    /**
     * 业务账号  是 2-18 个数字；业务账号，在用户中心-文本短信-业务账号中获取
     */
    @NotNull
    private String accountId;

    /**
     * 签名
     */
    @NotNull
    private String sign;

    /**
     * 审核状态
     */
    @NotNull
    private String auditStatus;

    /**
     * 回复时间
     */
    @NotNull
    private String finalSubCode;
}
