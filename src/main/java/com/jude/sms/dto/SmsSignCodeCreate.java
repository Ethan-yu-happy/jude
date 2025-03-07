package com.jude.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 14:50
 */
@EqualsAndHashCode(callSuper = true)
@Data

public class SmsSignCodeCreate  extends SmsAuth{
    @NotNull
    private String accountId; //业务账号  是 2-18 个数字；业务账号，在用户中心-文本短信-业务账号中获取

    /**
     * 最多 500 个
     */
    @NotNull
    private List<SmsSignCodeCreateData> data;

}
