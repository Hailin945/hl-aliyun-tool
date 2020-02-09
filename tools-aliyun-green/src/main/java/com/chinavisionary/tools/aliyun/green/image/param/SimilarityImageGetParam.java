package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@Data
public class SimilarityImageGetParam {

    /**
     * 要查询的图库的名称。如果不指定该参数，即从默认图库中查询。默认图库名称为default。
     */
    private String library;
    /**
     * 要查询的图片样本的ID。
     * 说明 必须传入dataId和url中的一个。
     */
    private String dataId;
    /**
     * 要查询的图片样本的URL。
     * 说明 必须传入dataId和url中的一个。
     */
    private String url;
}
