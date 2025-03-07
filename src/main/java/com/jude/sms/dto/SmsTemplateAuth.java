package com.jude.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-27 15:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsTemplateAuth extends SmsAuth {
    @NotNull
    private String templateid;
    @NotNull
    private String templateAuth; // 模板权限（0：共享，1：专享）
}
