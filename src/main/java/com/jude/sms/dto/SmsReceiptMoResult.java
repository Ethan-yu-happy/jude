package com.jude.sms.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 10:53
 */

public class SmsReceiptMoResult {
    /**
     * 回复的手机号码
     */
    @NotNull
    private String phone;
    /**
     * 回复内容
     */
    @NotNull
    @Length(max = 800)
    private String content;
    /**
     * 回复时间
     * yyyy-mm-dd hh:mm:ss
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date MOTime;
}
