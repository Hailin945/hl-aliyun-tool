package com.chinavisionary.tools.aliyun.green.common.constants;

/**
 * 建议执行的操作枚举
 *
 * @author Hailin
 * @date 2019/12/19
 */
public enum GreenSuggestionEnum {
    
    /**
     * 图片正常，无需进行其余操作；或者未识别出目标对象
     */
    PASS("pass"),
    /**
     * 检测结果不确定，需要进行人工审核；或者识别出目标对象
     */
    REVIEW("review"),
    /**
     * 图片违规，建议执行进一步操作（如直接删除或做限制处理）
     */
    BLOCK("block"),
    ;

    GreenSuggestionEnum(String code) {
    }
}
