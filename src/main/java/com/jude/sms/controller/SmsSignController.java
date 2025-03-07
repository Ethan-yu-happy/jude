package com.jude.sms.controller;

import com.jude.sms.dto.*;
import com.jude.sms.service.SmsSignService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-27 14:35
 */
@RestController
@RequestMapping("/sms")
public class SmsSignController {
    @Resource
    private SmsSignService smsSignService;

    @PostMapping("/SignQuery")
    public SmsSignResponse SignQuery(@RequestBody SmsSign smsSign) {

        return smsSignService.SignQuery(smsSign);
    }

    @PostMapping("/SignUpPull")
    public SmsSignResponse SignUpPull(@RequestBody SmsSignCodeCreate smsSignCodeCreate) {
        return smsSignService.SignUpPull(smsSignCodeCreate);
    }
}
