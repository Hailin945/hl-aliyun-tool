package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@Data
public class SimilarityImageCreateParam {

    /**
     * 要操作的图库的名称。如果不指定该参数，那么图片样本将被添加到默认图库中。默认图库名称为default。
     */
    private String library;
    /**
     * 要增加的图片样本列表。每个元素是个结构体，具体结构描述见task。
     */
    private List<ImageParam> tasks;
}
