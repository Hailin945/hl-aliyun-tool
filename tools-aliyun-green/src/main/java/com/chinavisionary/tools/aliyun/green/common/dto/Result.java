package com.chinavisionary.tools.aliyun.green.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求是否成功，true表示请求成功，false表示请求失败
     */
    private Boolean success;

    private String msg;
    /**
     * 本次请求ID
     */
    private String requestId;

    private String code;

    public Result() {
    }

    public Result(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Result(Boolean success, String msg, String requestId) {
        this.success = success;
        this.msg = msg;
        this.requestId = requestId;
    }

    public Result(Boolean success, String msg, String requestId, String code) {
        this.success = success;
        this.msg = msg;
        this.requestId = requestId;
        this.code = code;
    }
}
