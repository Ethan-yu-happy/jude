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
public class SmsTemplateQuery extends SmsAuth {
    @NotNull
    private String templateid;
}
