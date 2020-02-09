package com.chinavisionary.tools.aliyun.green.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hailin
 * @date 2019/12/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DataResult<T> extends Result {

    private T data;

    public DataResult() {
    }

    public DataResult(Boolean success, String msg) {
        super(success, msg);
    }

    public DataResult(Boolean success, String msg, T data) {
        super(success, msg);
        this.data = data;
    }

    public DataResult(Boolean success, String msg, String requestId, T data) {
        super(success, msg, requestId);
        this.data = data;
    }

    public DataResult(Boolean success, String msg, String code) {
        super(success, msg, null, code);
    }
}
