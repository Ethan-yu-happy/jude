package com.jude.sms.controller;
import com.jude.sms.dto.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.jude.sms.service.SmsTemplateService;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-27 14:35
 */
@RestController
@RequestMapping("/sms")
public class SmsTemplateController {
    @Resource
    private SmsTemplateService smsTemplateService;

    @PostMapping("/createTemplate")
    public SmsTemplateCreateResponse createTemplate(@RequestBody SmsTemplateCreate smsTemplate) {
        return smsTemplateService.createTemplate(smsTemplate); // 调用服务层方法创建模板
    }

    @PostMapping("/updateTemplate")
    public SmsTemplateUpdateResponse updateTemplate(@RequestBody SmsTemplateUpdate smsTemplate) {
        return smsTemplateService.updateTemplate(smsTemplate); // 调用服务层方法更新模板
    }

    @PostMapping("/deleteTemplate")
    public SmsTemplateDeleteResponse deleteTemplate(@RequestBody SmsTemplateDelete smsTemplate) {
        return smsTemplateService.deleteTemplate(smsTemplate); // 调用服务层方法删除模板
    }

    @PostMapping("/queryTemplate")
    public SmsTemplateQueryResponse queryTemplate(@RequestBody SmsTemplateQuery smsTemplate) {
        return smsTemplateService.queryTemplate(smsTemplate); // 调用服务层方法查询模板
    }
}
