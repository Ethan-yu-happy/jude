package com.jude.sms.service;

import com.alibaba.fastjson2.JSONObject;

import com.jude.sms.client.ApiHttpClient;
import com.jude.sms.enums.SMServiceEnums;
import com.jude.sms.dto.SmsSign;
import com.jude.sms.dto.SmsSignCodeCreate;
import com.jude.sms.dto.SmsSignResponse;
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
public class SmsSignService {
    @Resource
    private ApiHttpClient apiHttpClient;

    private final String SUCCESS_CODE = "0000";

    /**
     * 短信回执查询接口
     * @param smsSign
     * @return
     */
    public SmsSignResponse SignQuery(SmsSign smsSign) {
        String stringResponseEntity = apiHttpClient.getStringResponseEntity(smsSign, SMServiceEnums.SIGN_QUERY);
        SmsSignResponse smsSignResponse = JSONObject.parseObject(stringResponseEntity, SmsSignResponse.class);
        return smsSignResponse;
    }

    /**
     * 短信上行拉取接口
     * @param smsSign
     * @return
     */
    public SmsSignResponse SignUpPull(SmsSignCodeCreate smsSign) {

        String stringResponseEntity = apiHttpClient.getStringResponseEntity(smsSign, SMServiceEnums.SIGN_CREATE);
        SmsSignResponse smsSignMoPullResponse = JSONObject.parseObject(stringResponseEntity, SmsSignResponse.class);
        return smsSignMoPullResponse;
    }



}
