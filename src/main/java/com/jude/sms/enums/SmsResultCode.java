package com.jude.sms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SmsResultCode {
    DELIVRD("成功发送");
    private final String desc;
}
