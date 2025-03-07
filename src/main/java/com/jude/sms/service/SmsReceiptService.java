package com.jude.sms.service;

import com.alibaba.fastjson2.JSONObject;
import com.jude.sms.client.ApiHttpClient;
import com.jude.sms.enums.SMServiceEnums;
import com.jude.sms.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-28 10:48
 */
@Service
@Slf4j
public class SmsReceiptService {
    @Resource
    private ApiHttpClient apiHttpClient;

    private final String SUCCESS_CODE = "0000";

    /**
     * 短信回执查询接口
     * @param smsReceipt
     * @return
     */
    public SmsReceiptResponse<SmsReceiptSmsResult> receiptQuery(SmsReceipt smsReceipt) {
        smsReceipt.setAccountId("100396344471");
        String stringResponseEntity = apiHttpClient.getStringResponseEntity(smsReceipt, SMServiceEnums.RECEIPT_QUERY);
        SmsReceiptResponse<SmsReceiptSmsResult> smsReceiptResponse = JSONObject.parseObject(stringResponseEntity, SmsReceiptResponse.class);
        return smsReceiptResponse;
    }

    /**
     * 短信上行拉取接口
     * @param smsReceipt
     * @return
     */
    public SmsReceiptMoPullResponse receiptUpPull(SmsReceiptMoPull smsReceipt) {
        smsReceipt.setAccountId("100396344471");
        String stringResponseEntity = apiHttpClient.getStringResponseEntity(smsReceipt, SMServiceEnums.RECEIPT_UP_PULL);
        SmsReceiptMoPullResponse smsReceiptMoPullResponse = JSONObject.parseObject(stringResponseEntity, SmsReceiptMoPullResponse.class);
        return smsReceiptMoPullResponse;
    }

    /**
     * 短信上行拉取接口
     * @param smsReceipt
     * @return
     */
    public SmsReceiptResponse<SmsReceiptMoResult> receiptUpQuery(SmsReceipt smsReceipt) {
        smsReceipt.setAccountId("100396344471");
        String stringResponseEntity = apiHttpClient.getStringResponseEntity(smsReceipt, SMServiceEnums.RECEIPT_UP_QUERY);
        SmsReceiptResponse<SmsReceiptMoResult> smsReceiptResponse = JSONObject.parseObject(stringResponseEntity, SmsReceiptResponse.class);
        return smsReceiptResponse;
    }

    public static void main(String[] args) {
        String stringResponseEntity = "{\n" +
                "    \"respCode\": \"0000\",\n" +
                "    \"respDesc\": \"è¯·æ±\u0082æ\u0088\u0090å\u008A\u009Fã\u0080\u0082\",\n" +
                "    \"smsResult\": null\n" +
                "}";
        SmsReceiptResponse<SmsReceiptMoResult> smsReceiptResponse = JSONObject.parseObject(stringResponseEntity, SmsReceiptResponse.class);

    }
}
