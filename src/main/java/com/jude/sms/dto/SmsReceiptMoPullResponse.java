package com.jude.sms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 10:04
 */
@Data
public class SmsReceiptMoPullResponse extends SmsResponse {
    /**
     * 响应数据类型，目前支持 JSON
     */
    @NotNull
    private List<SmsReceiptMoResult> respDataType;
}
