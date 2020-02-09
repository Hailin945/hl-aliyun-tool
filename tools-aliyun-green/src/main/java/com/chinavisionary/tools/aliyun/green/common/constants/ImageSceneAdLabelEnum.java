package com.chinavisionary.tools.aliyun.green.common.constants;

/**
 * 图文违规识别标签枚举
 *
 * @author Hailin
 * @date 2019/12/19
 */
public enum ImageSceneAdLabelEnum {

    /**
     * 正常图片
     */
    NORMAL("normal", "正常图片"),
    AD("ad", "广告图片"),
    ;

    private String code;

    private String description;

    ImageSceneAdLabelEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
