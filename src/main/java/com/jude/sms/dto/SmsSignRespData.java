package com.jude.sms.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yuzhihang
 * @Description
 * @create 2025-03-01 14:58
 */
@Data
public class SmsSignRespData {

    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;
    @NotNull
    private Integer total;

    private List<SmsSignRecord> record;



}
