package com.chinavisionary.tools.aliyun.green.text.dto;

import lombok.Data;

/**
 * 文本命中的关键词信息，用于提示您违规的原因.
 *
 * @author Hailin
 * @date 2019/12/19
 */
@Data
public class TextScanHintWordDTO {

    /**
     * 文本命中的系统关键词内容。
     */
    private String context;
}
