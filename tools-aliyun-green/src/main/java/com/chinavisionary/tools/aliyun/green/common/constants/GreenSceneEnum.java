package com.chinavisionary.tools.aliyun.green.common.constants;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 阿里云绿网服务应用场景枚举
 *
 * @author Hailin
 * @date 2019/12/17
 */
public enum GreenSceneEnum {

    /**
     * 图片智能鉴黄
     */
    IMAGE_PORN("porn", "图片智能鉴黄"),
    IMAGE_TERRORISM("terrorism", "图片暴恐涉政识别"),
    IMAGE_AD("ad", "图文违规识别"),
    IMAGE_QRCODE("qrcode", "图片二维码识别"),
    IMAGE_LIVE("live", "图片不良场景识别"),
    IMAGE_LOGO("logo", "图片logo识别"),
    IMAGE_OCR("ocr", "文字识别"),
    IMAGE_SFACE("sface", "敏感人脸识别"),
    IMAGE_SFACE_1("sface-1", "人脸对比"),
    IMAGE_LIVENENSS("liveness", "活体翻拍检测"),
    IMAGE_TAG("tag", "标签"),
    IMAGE_SIMILARITY("similarity", "相似图检索"),
    IMAGE_SFACE_N("sface-n", "自定义人脸检索"),

    TEXT_ANTISPAM("antispam", "反垃圾邮件"),
    ;

    private String code;

    private String description;

    GreenSceneEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static GreenSceneEnum getEnumByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (GreenSceneEnum value : values()) {
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
        for (GreenSceneEnum value : values()) {
            if (Objects.equals(value.getCode(), code)) {
                return value.getDescription();
            }
        }
        return null;
    }
}
