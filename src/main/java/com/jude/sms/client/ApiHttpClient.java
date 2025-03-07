package com.jude.sms.client;

import com.alibaba.fastjson2.JSONObject;

import com.jude.sms.dto.SmsReceiptMoResult;
import com.jude.sms.dto.SmsReceiptResponse;
import com.jude.sms.dto.SmsResponse;
import com.jude.sms.enums.SMServiceEnums;
import com.jude.sms.dto.SmsAuth;
import jdk.nashorn.internal.ir.CallNode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.IClassFileProvider;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-27 16:20
 */
@Configuration
@Data
@Slf4j
@Validated
public class ApiHttpClient {
    @Value("${sms.api.baseUrl}")
    private String baseUrl;  // API接口基础URL配置，类似：https://openapi.danmi.com

    @Value("${sms.api.accountSid}")
    private String accountSid; // 开发者主账号

    @Value("${sms.api.authToken}")
    private String authToken; // 认证令牌

    @Autowired
    @Lazy
    RestTemplate restTemplate;

    @Bean
    public RestTemplate init() {
        RestTemplate client = new RestTemplate();
        client.getMessageConverters().
                add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return client;
    }

    private String getApiUrl(String endpoint) {
        return baseUrl + endpoint;
    }

    // 获取加签sig的通用方法
    private String generateSig(Long timestamp) {
        String sig = accountSid + authToken + timestamp;
        try {
            // 这里可以调用MD5加密方法
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = sig.getBytes(StandardCharsets.UTF_8);
            byte[] digest = instance.digest(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            log.info("没有MD5解析功能");
            return null;
        }
    }


    public String getStringResponseEntity(@NotNull Object request, @NotNull SMServiceEnums smServiceEnums) {
        if (request instanceof SmsAuth) {
            SmsAuth smsAuth = (SmsAuth) request;
            smsAuth.setAccountSid(accountSid);
            smsAuth.setTimestamp(System.currentTimeMillis());
            smsAuth.setSig(generateSig(smsAuth.getTimestamp()));
        }

        String url = getApiUrl(smServiceEnums.getOperate());
        HttpHeaders headers = new HttpHeaders();
        String requestJson = JSONObject.toJSONString(request);
        headers.set("Content-Type", "application/json");
        log.info("[{}]req:[{}]", smServiceEnums.getDesc(),requestJson);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,
                new HttpEntity<>(requestJson, headers), String.class);
        String body = response.getBody();
        SmsResponse smsReceiptResponse = JSONObject.parseObject(body, SmsResponse.class);

        log.info("[{}]res:[{}]", smServiceEnums.getDesc(), body);
        return body;
    }
}
