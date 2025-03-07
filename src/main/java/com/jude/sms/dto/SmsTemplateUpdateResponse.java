package com.jude.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-28 11:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsTemplateUpdateResponse extends SmsResponse  {
    @NotNull
    private String templateid; // 模板ID
    @NotNull
    private String templateName; // 模板名称
    @NotNull
    private String templateContent; // 模板内容
    @NotNull
    private String templateSign; // 短信签名
    @NotNull
    private Integer templateAuth; // 模板权限
}
