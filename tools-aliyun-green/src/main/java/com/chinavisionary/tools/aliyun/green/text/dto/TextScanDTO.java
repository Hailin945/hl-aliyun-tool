package com.chinavisionary.tools.aliyun.green.text.dto;

import com.chinavisionary.tools.aliyun.green.common.dto.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TextScanDTO extends Result {

    /**
     * 数据Id。需要保证在一次请求中所有的Id不重复。
     */
    private String dataId;
    /**
     * 待检测文本，最长10000个字符。
     */
    private String content;
    /**
     * 该检测任务的ID。
     */
    private String taskId;
    /**
     * 如果检测文本命中您自定义关键词词库中的词，该字段会返回，并将命中的关键词替换为“*”。
     */
    private String filteredContent;
    /**
     * 返回结果。
     * 调用成功时（code=200），返回结果中包含一个或多个元素。每个元素是个结构体，具体结构描述见result。
     */
    private List<TextScanResultDTO> results;
}
