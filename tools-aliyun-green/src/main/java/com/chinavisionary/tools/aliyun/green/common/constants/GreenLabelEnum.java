package com.chinavisionary.tools.aliyun.green.common.constants;

/**
 * 阿里云绿网服务中场景对应的标签分类枚举
 *
 * @author Hailin
 * @date 2019/12/19
 */
public enum GreenLabelEnum {
    /**
     * 正常文本
     */
    TEXT_NORMAL("normal", "正常文本"),
    TEXT_SPAM("spam", "含垃圾信息"),
    TEXT_AD("ad", "广告"),
    TEXT_POLITICS("politics", "涉政"),
    TEXT_TERRORISM("terrorism", "暴恐"),
    TEXT_ABUSE("abuse", "辱骂"),
    TEXT_PORN("porn", "色情"),
    TEXT_FLOOD("flood", "灌水"),
    TEXT_CONTRABAND("contraband", "违禁"),
    TEXT_MEANINGLESS("meaningless", "无意义"),
    TEXT_CUSTOMIZED("customized", "自定义（例如命中自定义关键词）"),
    ;

    private String code;

    private String description;

    GreenLabelEnum(String code, String description) {
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
