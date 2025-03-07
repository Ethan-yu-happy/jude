package com.jude.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-28 11:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsTemplateQueryResponse extends SmsResponse  {
    @NotNull
    private String templateid; // 模板ID

    @NotNull
    private String templateName; // 模板名称
    @NotNull
    private String templateContent; // 模板内容
//    @NotNull
    private String templateSign; // 短信签名
    /**
     * 1、待审核，2、审核成功，3、审核失败
     */
    @NotNull
    private String verifyStatus; // 审核状态
    @NotNull
    private String verifyStatusMsg; // 结果描述
    @NotNull
    private Integer templateAuth; // 模板权限
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime  ;
}
