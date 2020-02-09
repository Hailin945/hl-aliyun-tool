package com.chinavisionary.tools.aliyun.green.common.constants;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 阿里云区域枚举
 *
 * @author Hailin
 * @date 2019/12/9
 */
public enum RegionGreenEnum {
    /**
     * 华东 2
     */
    CN_SHANGHAI("cn-shanghai"),
    /**
     * 华北 2
     */
    CN_BEIJING("cn-beijing"),
    /**
     * 华南1
     */
    CN_SHENZHEN("cn-shenzhen"),
    /**
     * 新加坡
     */
    AP_SOUTHEAST_1("ap-southeast-1"),
    /**
     * 美西
     */
    US_WEST_1("us-west-1"),
    ;

    private String code;

    RegionGreenEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static RegionGreenEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (RegionGreenEnum e : values()) {
            if (Objects.equals(e.getCode(), code)) {
                return e;
            }
        }
        return null;
    }
}