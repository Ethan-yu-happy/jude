package com.jude.sms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 08:30
 */
@Data
public class SmsBatchCell {
    @NotNull
    private String to; // 不能重复｜逗号分割｜一次最多50｜个手机号
    @NotNull
    private String smsContent; //业务账号  是 2-18 个数字；业务账号，在用户中心-文本短信-业务账号中获取
    private String expandId; //扩展码  否 扩展码

    private String customSmsId;// 用户自定义  否 用户业务自定义字段
}
