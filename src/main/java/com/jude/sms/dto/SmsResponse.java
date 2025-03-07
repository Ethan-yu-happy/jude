package com.jude.sms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-27 15:22
 */

@Data
public class SmsResponse {
    @NotNull // 响应结果码
    private String respCode;
    @NotNull// 响应描述
    private String respDesc;

}
