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
public class SmsSendService {
    @Resource
    private ApiHttpClient apiHttpClient;

    private final String SUCCESS_CODE = "0000";

    public SmsSendResponse sendV1(SmsSendV1 smsSendV1) {
        smsSendV1.setAccountId("100396344471");
        String stringResponseEntity = apiHttpClient.getStringResponseEntity(smsSendV1, SMServiceEnums.SEND_V1);
        SmsSendResponse smsSendResponse = JSONObject.parseObject(stringResponseEntity, SmsSendResponse.class);
        return smsSendResponse;

    }

    public SmsSendResponse sendV2(SmsSendV2 smsSendV2) {
        String stringResponseEntity = apiHttpClient.getStringResponseEntity(smsSendV2, SMServiceEnums.SEND_V2);
        SmsSendResponse smsSendResponse = JSONObject.parseObject(stringResponseEntity, SmsSendResponse.class);
        return smsSendResponse;
    }

    public SmsSendVBatchResponse sendBatchV1(SmsSendVBatch smsSendVBatch) {
        String stringResponseEntity = apiHttpClient.getStringResponseEntity(smsSendVBatch, SMServiceEnums.SEND_BATCH_V1);
        SmsSendVBatchResponse smsSendResponse = JSONObject.parseObject(stringResponseEntity, SmsSendVBatchResponse.class);
        return smsSendResponse;
    }

}
