package com.chinavisionary.tools.aliyun.green.common.constants;

/**
 * 图片智能鉴黄标签
 *
 * @author Hailin
 * @date 2019/12/19
 */
public enum ImageScenePornLabelEnum {

    /**
     * 正常图片
     */
    NORMAL("normal", "正常图片"),
    SEXY("sexy", "性感图片"),
    PRON("porn", "色情图片"),
    ;

    private String code;

    private String description;

    ImageScenePornLabelEnum(String code, String description) {
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
