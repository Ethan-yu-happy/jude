package com.jude.sms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-02-27 15:22
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class SmsBatchFailCell extends SmsResponse {
    private String to;


}
