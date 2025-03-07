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
public class SmsTemplateUpdate extends SmsAuth {
    @NotNull
    private String accountId; // 业务账号
    /**
     * 创建模板时返回
     */
    @NotNull
    private String templateid;
    @NotNull
    private String templateName; // 模板名称
    @NotNull
    private String templateContent; // 模板内容
    @NotNull
    private String templateSign; // 短信签名
}
