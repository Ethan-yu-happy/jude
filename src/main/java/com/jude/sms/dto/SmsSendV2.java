package com.jude.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-28 10:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsSendV2 extends SmsAuth {
    private String templateid;//模板 ID   模板ID，和短信内容必传一个
    private String smsContent;// 短信内容  否 短信内容，和模板 ID 必传一个

    @NotNull
    private String to; //手机号 String 是 发送手机号，多个手机号，用英文逗号隔开 一次最多1000 个手机号
    private String expandId; //扩展码  否 扩展码
    private List<String> paramsList; //短信变量  否 短信变量，多个变量用英文逗号隔开    @NotNull
    @NotNull
    private String accountId; //业务账号  是 2-18 个数字；业务账号，在用户中心-文本短信-业务账号中获取
    private String customSmsId;// 用户自定义  否 用户业务自定义字段



}
