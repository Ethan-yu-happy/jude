package com.jude.sms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 10:04
 */
@Data
public class SmsReceipt extends SmsAuth {
    /**
     * 业务账号  是 2-18 个数字；业务账号，在用户中心-文本短信-业务账号中获取
     */
    @NotNull
    private String accountId;

    /**
     * 默认 100 条，限制不超过 2000 条
     */
    private Integer count;
}
