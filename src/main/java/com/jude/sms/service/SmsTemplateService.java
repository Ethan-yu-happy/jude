package com.jude.sms.service;

import com.alibaba.fastjson2.JSONObject;
import com.jude.sms.client.ApiHttpClient;

import com.jude.sms.enums.SMServiceEnums;
import com.jude.sms.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;


/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-27 15:26
 */
@Service
@Slf4j
public class SmsTemplateService {
    @Resource
    private ApiHttpClient apiHttpClient;
    @Resource
    private RestTemplate restTemplate;

    private final String SUCCESS_CODE = "0000";

    // 创建短信模板
    public SmsTemplateCreateResponse createTemplate(SmsTemplateCreate smsTemplate) {
        // 发送POST请求
        String response = apiHttpClient.getStringResponseEntity(smsTemplate, SMServiceEnums.TEMPLATE_CREATE);
        // 解析API响应并返回
        SmsTemplateCreateResponse smsResponse = JSONObject.parseObject(response, SmsTemplateCreateResponse.class);
        if (Objects.nonNull(smsResponse) && SUCCESS_CODE.equals(smsResponse.getRespCode())) {
            // todo 数据落表
        }
        return smsResponse;
    }


    // 更新短信模板
    public SmsTemplateUpdateResponse updateTemplate(SmsTemplateUpdate smsTemplate) {
        // 调用API接口更新模板的逻辑
        String response = apiHttpClient.getStringResponseEntity(smsTemplate, SMServiceEnums.TEMPLATE_UPDATE);
        SmsTemplateUpdateResponse smsResponse = JSONObject.parseObject(response, SmsTemplateUpdateResponse.class);
        if (Objects.nonNull(smsResponse) && SUCCESS_CODE.equals(smsResponse.getRespCode())) {
            // todo 数据落表
        }
        return smsResponse;
    }

    // 删除短信模板
    public SmsTemplateDeleteResponse deleteTemplate(SmsTemplateDelete smsTemplate) {
        // 调用API接口删除模板的逻辑
        String response = apiHttpClient.getStringResponseEntity(smsTemplate, SMServiceEnums.TEMPLATE_DELETE);
        SmsTemplateDeleteResponse smsResponse = JSONObject.parseObject(response, SmsTemplateDeleteResponse.class);
        if (Objects.nonNull(smsResponse) && SUCCESS_CODE.equals(smsResponse.getRespCode())) {
            // todo 数据落表
        }
        return smsResponse;
    }

    // 查询短信模板
    public SmsTemplateQueryResponse queryTemplate(SmsTemplateQuery smsTemplate) {
        // 调用API接口查询模板的逻辑
        String response = apiHttpClient.getStringResponseEntity(smsTemplate, SMServiceEnums.TEMPLATE_QUERY);
        SmsTemplateQueryResponse smsResponse = JSONObject.parseObject(response, SmsTemplateQueryResponse.class);
        if (Objects.nonNull(smsResponse) && SUCCESS_CODE.equals(smsResponse.getRespCode())) {
            // todo 数据落表
        }
        return smsResponse;
    }
}
