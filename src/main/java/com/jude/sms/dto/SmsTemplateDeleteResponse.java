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
public class SmsTemplateDeleteResponse extends SmsResponse  {
    @NotNull
    private String templateid; // 模板ID
}
