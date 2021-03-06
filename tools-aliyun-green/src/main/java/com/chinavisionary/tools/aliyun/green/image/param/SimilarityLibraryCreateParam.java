package com.chinavisionary.tools.aliyun.green.image.param;

import com.chinavisionary.tools.aliyun.green.common.param.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 创建相似图库请求参数对象
 *
 * @author Hailin
 * @date 2019/12/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SimilarityLibraryCreateParam extends BaseParam {

    /**
     * 要增加的图库的名称。同区域内的所有图库名称必须唯一。名称长度在64个字符以内，可以是中文、英文、下划线的组合。
     */
    private String name;
}
