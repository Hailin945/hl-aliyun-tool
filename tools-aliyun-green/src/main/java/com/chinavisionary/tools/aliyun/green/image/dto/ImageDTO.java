package com.chinavisionary.tools.aliyun.green.image.dto;

import com.chinavisionary.tools.aliyun.green.common.dto.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片样本数据传输对象
 *
 * @author Hailin
 * @date 2019/12/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageDTO extends Result {

    /**
     * 该样本在您的业务系统里的唯一ID。例如，您可以指定该样本ID为"1"、"s-001"等。
     */
    private String dataId;
    /**
     * 样本图片的URL。
     */
    private String url;
    /**
     * 图片样本的标签。
     */
    private String tags;
    /**
     * 在图库中创建图片样本的时间戳。
     */
    private Long createTime;
}
