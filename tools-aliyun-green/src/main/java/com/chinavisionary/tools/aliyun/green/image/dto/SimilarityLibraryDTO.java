package com.chinavisionary.tools.aliyun.green.image.dto;

import com.chinavisionary.tools.aliyun.green.common.dto.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图库数据传输对象
 *
 * @author Hailin
 * @date 2019/12/18
 */
@Data
public class SimilarityLibraryDTO {

    /**
     * 图库名称。
     */
    private String name;
    /**
     * 创建图库的时间戳。
     */
    private Long createTime;
    /**
     * 图库中的图片样本的数量。
     */
    private Integer imageCount;
    /**
     * 图库所属区域。
     */
    private String region;
}
