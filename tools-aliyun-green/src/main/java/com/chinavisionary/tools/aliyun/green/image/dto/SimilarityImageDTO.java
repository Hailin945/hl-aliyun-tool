package com.chinavisionary.tools.aliyun.green.image.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/19
 */
@Data
public class SimilarityImageDTO {

    /**
     * 命中的样本图片在您的业务系统里的唯一ID。
     */
    private String dataId;
    /**
     * 命中的样本图片的URL。
     */
    private String url;
    /**
     * 命中的样本图片的标签值。
     */
    private List<String> tags;
    /**
     * 样本图片所在图库的名称。
     */
    private String library;
    /**
     * 被检测图片与命中的样本图片的相似度，取值范围为[0.00-100.00]。值越高，表示越有可能命中该样本图片。
     */
    private Double rate;
    /**
     *
     */
    private String imageId;
}
