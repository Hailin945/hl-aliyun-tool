package com.chinavisionary.tools.aliyun.green.text.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/19
 */
@Data
public class TextScanDetailDTO {

    /**
     * 文本命中风险的分类，与具体的scene对应。取值范围参考scene 和 label说明。
     */
    private String label;
    /**
     * 命中该风险的上下文信息。具体结构描述见context。
     */
    private List<TextScanContextDTO> contexts;
    /**
     * 文本命中的关键词信息，用于提示您违规的原因，可能会返回多个命中的关键词。具体结构描述见hintWord。
     */
    private List<TextScanHintWordDTO> hintWords;
}
