package com.chinavisionary.tools.aliyun.green.common.constants;

/**
 * 图片暴恐涉政识别标签枚举
 *
 * @author Hailin
 * @date 2019/12/19
 */
public enum ImageSceneTerrorismLabelEnum {

    /**
     * 正常图片
     */
    NORMAL("normal", "正常图片"),
    BLOODY("bloody", "血腥"),
    EXPLOSION("explosion", "爆炸烟光"),
    OUTFIT("outfit", "特殊装束"),
    LOGO("logo", "特殊标识"),
    WEAPON("weapon", "武器"),
    POLITICS("politics", "涉政"),
    VIOLENCE("violence", "打斗"),
    CROWD("crowd", "聚众"),
    PARADE("parade", "游行"),
    CAR_CRASH("carcrash", "车祸现场"),
    FLAG("flag", "旗帜"),
    LOCATION("location", "地标"),
    OTHERS("others", "其他");

    private String code;

    private String description;

    ImageSceneTerrorismLabelEnum(String code, String description) {
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
