package com.chinavisionary.tools.aliyun.green.image.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/17
 */
@Data
public class TagDataDTO {

    /**
     * 标签概要信息
     */
    private List<TagSummaryDTO> summary;
}
