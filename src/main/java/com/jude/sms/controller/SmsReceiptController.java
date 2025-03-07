package com.jude.sms.controller;

import com.jude.sms.dto.*;
import com.jude.sms.service.SmsReceiptService;
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
public class SmsReceiptController {
    @Resource
    private SmsReceiptService smsReceiptService;

    @PostMapping("/receiptQuery")
    public SmsReceiptResponse<SmsReceiptSmsResult> receiptQuery(@RequestBody SmsReceipt smsReceipt) {

        return smsReceiptService.receiptQuery(smsReceipt);
    }

    @PostMapping("/receiptUpPull")
    public SmsReceiptMoPullResponse receiptUpPull(@RequestBody SmsReceiptMoPull smsReceipt) {
        return smsReceiptService.receiptUpPull(smsReceipt);
    }

    @PostMapping("/receiptUpQuery")
    public SmsReceiptResponse<SmsReceiptMoResult>  receiptUpQuery(@RequestBody SmsReceipt smsReceipt) {
        return smsReceiptService.receiptUpQuery(smsReceipt );
    }


}
