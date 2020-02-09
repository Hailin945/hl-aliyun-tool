package com.chinavisionary.tools.aliyun.sms.common.dto;

import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/10
 */
@Data
public class Result<T> {

    private String code;

    private String msg;

    private Boolean success;

    private String requestId;

    private T data;
}
