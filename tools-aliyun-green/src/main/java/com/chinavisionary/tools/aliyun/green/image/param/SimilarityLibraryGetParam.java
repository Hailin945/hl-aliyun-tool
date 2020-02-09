package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;

/**
 * 查询指定图库信息请求参数接口
 *
 * @author Hailin
 * @date 2019/12/18
 */
@Data
public class SimilarityLibraryGetParam {

    /**
     * 要增加的图库的名称。同区域内的所有图库名称必须唯一。名称长度在64个字符以内，可以是中文、英文、下划线的组合。
     */
    private String name;
}
