package com.jude.sms.dto;

import com.jude.sms.enums.SmsResultCode;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 10:15
 */
@Data
public class SmsReceiptSmsResult {
    @NotNull
    private String smsId;//  短信标识符  是 一个由 32 个字符组成的短信唯一标识符。 和提交时 smsId 对应

    private String phone;// 手机号码 String 否 短信发送的手机号码

    @NotNull
    private String status;// 发送状态 String 是 0：成功；1：失败

    private String respMessage;// 内容描述 String 否 短信回执具体内容描述（网关返回错误码）。

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date receiveTime;// 接收时间 String 是 短信接收时间。发送成功返回回执中到达的具体时间， 如果为未知状态或失败状态，则为空。格式为

    @NotNull
    private int chargingNum;// 计费条数 int 是 短信签名+短信内容 70 字以内包含 70 字为 1 条，超过 70 字则按每条为 67 字计算条数。

    private SmsResultCode respCode;// 状态码 String 否 短信回执具体状态码，一般情况：“DELIVRD” 成
}
