package com.jude.sms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SMServiceEnums {
    TEMPLATE_CREATE("/textSMS/smsTemplate/create", "短信创建模版接口"),
    TEMPLATE_UPDATE("/textSMS/smsTemplate/update", "短信修改模版接口"),
    TEMPLATE_DELETE("/textSMS/smsTemplate/delete", "短信删除模版接口"),
    TEMPLATE_QUERY("/textSMS/smsTemplate/query", "短信查询模版接口"),
    TEMPLATE_AUTH_UPDATE("/textSMS/smsTemplate/auth/update", "短信编辑模板权限接口"),

    SEND_V1("/textSMS/sendSMS/V1", "普通发送 V1"),
    SEND_V2("/textSMS/sendSMS/V2", "普通发送 V2"),
    SEND_BATCH_V1("/textSMS/sendSMS/batch/V1", "批量发送"),

    RECEIPT_QUERY("/receipt/pull","短信回执查询接口"),
    RECEIPT_UP_PULL("/pull/mo","短信上行拉取接口"),
    RECEIPT_UP_QUERY("/textSMS/mo/pull","短信上行查询接口"),

    SIGN_QUERY("/sign/signQuery","签名查询接口"),
    SIGN_CREATE("/sign/signCodeCreate","签名子码用户拓展接口"),




    ;
    private final String operate;
    private final String desc;

}
