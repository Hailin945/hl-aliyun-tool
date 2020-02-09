package com.chinavisionary.tools.aliyun.sms.template.constants;

import java.util.Objects;

/**
 * @author Hailin
 * @date 2019/12/10
 */
public enum SmsTemplateStatusEnum {
    /**
     *
     */
    AUDITING(0, "审核中"),
    PASS(1, "审核通过"),
    FAILED(2, "审核失败");

    private Integer code;

    private String name;

    SmsTemplateStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static SmsTemplateStatusEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (SmsTemplateStatusEnum templateStatusEnum : values()) {
            if (Objects.equals(templateStatusEnum.getCode(), code)) {
                return templateStatusEnum;
            }
        }
        return null;
    }
}
