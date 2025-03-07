package com.jude.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 14:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsSign  extends SmsAuth{
    /**
     *
     */
    private String accountId; //业务账号  是 2-18 个数字；业务账号，在用户中心-文本短信-业务账号中获取

    /**
     *最多 100 个
     */
    @NotNull
    private List<String> signs;
    @NotNull
    private Integer pageSize;
    @NotNull
    private Integer pageNum;
}
