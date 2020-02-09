package com.chinavisionary.tools.aliyun.green.common.constants;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 阿里云绿网服务文件检测应用场景枚举
 *
 * @author Hailin
 * @date 2019/12/17
 */
public enum GreenFileSceneEnum {

    /**
     * 鉴黄
     */
    IMAGE_PORN("porn", "鉴黄"),
    IMAGE_AD("ad", "广告"),
    IMAGE_TERRORISM("terrorism", "暴恐涉政"),
    IMAGE_SFACE("sface", "敏感人脸"),
    IMAGE_QRCODE("qrcode", "二维码"),
    IMAGE_LIVE("live", "不良场景"),
    IMAGE_LOGO("logo", "logo识别"),
    IMAGE_OCR("ocr", "OCR图文识别"),

    TEXT_ANTISPAM("antispam", "反垃圾信息"),
    ;

    private String code;

    private String description;

    GreenFileSceneEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static GreenFileSceneEnum getEnumByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (GreenFileSceneEnum value : values()) {
            if (Objects.equals(value.getCode(), code)) {
                return value;
            }
        }
        return null;
    }

    public static String getDescriptionByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (GreenFileSceneEnum value : values()) {
            if (Objects.equals(value.getCode(), code)) {
                return value.getDescription();
            }
        }
        return null;
    }
}
