package com.chinavisionary.tools.aliyun.sms.common.constants;

/**
 * 阿里云区域枚举
 *
 * @author Hailin
 * @date 2019/12/9
 */
public enum AliyunRegionEnum {
    /**
     *
     */
    CN_HANGZHOU("cn-hangzhou");

    private String code;

    AliyunRegionEnum(String code) {
        code = code;
    }

    public String getCode() {
        return code;
    }
}
