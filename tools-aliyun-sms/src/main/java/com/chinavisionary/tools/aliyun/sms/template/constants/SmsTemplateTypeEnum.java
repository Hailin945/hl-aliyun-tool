package com.chinavisionary.tools.aliyun.sms.template.constants;

import java.util.Objects;

/**
 * @author Hailin
 * @date 2019/12/9
 */
public enum SmsTemplateTypeEnum {
    /**
     * 验证码
     */
    VERIFICATION_CODE(0, "验证码"),
    NOTIFICATION(1, "短信通知"),
    PUSH_MESSAGE(2, "推广短信"),
    INTERNATIONAL_MESSAGE(3, "国际/港澳台消息"),
    ;

    private Integer code;

    private String name;

    SmsTemplateTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static SmsTemplateTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (SmsTemplateTypeEnum typeEnum : values()) {
            if (Objects.equals(typeEnum.getCode(), code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
