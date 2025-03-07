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
public class SmsTemplateCreate extends SmsAuth {
    @NotNull
    private String accountId; // 业务账号
    @NotNull
    private String templateSign; // 短信签名
    @NotNull
    private String templateName; // 模板名称
    @NotNull
    private String templateContent; // 模板内容
    private int templateAuth; // 模板权限（0：共享，1：专享）
}
