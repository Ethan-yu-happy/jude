package com.jude.sms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-28 10:29
 */
@Data
public class SmsAuth {
    @NotNull
    private String accountSid; // 开发者主账号
    @NotNull
    private Long timestamp; // 时间戳
    @NotNull
    private String sig; // 加签
}
