package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@Data
public class SimilarityImageDeleteParam {

    /**
     * 要移除的样本图片的dataId列表。每个元素是字符串类型，一次最多允许移除100张样本图片。
     * 说明：如果指定了该参数，则不用指定urls。
     */
    private List<String> dataIds;
    /**
     * 要移除的样本图片的url列表。每个元素是字符串类型，一次最多允许移除100张样本图片。
     * 说明：如果指定了该参数，则不用指定dataIds。
     */
    private List<String> urls;
    /**
     * 要操作的图库的名称。如果不指定该参数，即从默认图库中删除图片样本。默认图库的名称为default。
     */
    private String library;
}
