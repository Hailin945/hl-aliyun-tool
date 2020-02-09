package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@Data
public class SimilarityImageListParam {

    /**
     * 每页大小，取值范围：(0,50]。
     */
    private Integer pageSize;
    /**
     * 当前页码，取值范围：(0,50]。
     */
    private Integer currentPage;
    /**
     * 要查询的图库的名称。如果不指定该参数，即从默认图库中查询。默认图库名称为default。
     */
    private String library;
}
