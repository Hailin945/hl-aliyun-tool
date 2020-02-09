package com.chinavisionary.tools.aliyun.green.image.dto;

import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/17
 */
@Data
public class TagSummaryDTO {

    /**
     * 标签中文名称。
     */
    private String tagCnName;
    /**
     * 标签英文名称。
     */
    private String tagEnName;
    /**
     * 标签所属的分类中文名称。
     */
    private String cnCategory;
    /**
     * 标签所属的分类英文名称。
     */
    private String enCategory;
    /**
     * 结果为标签的概率，取值范围[0,100]。取值越大，则越有可能属于标签。
     */
    private Double rate;
}
