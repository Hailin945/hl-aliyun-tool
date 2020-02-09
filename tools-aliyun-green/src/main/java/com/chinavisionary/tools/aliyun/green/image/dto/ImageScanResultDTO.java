package com.chinavisionary.tools.aliyun.green.image.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/17
 */
@Data
public class ImageScanResultDTO {

    /**
     * 图片检测场景
     */
    private String scene;
    /**
     * 检测结果的分类，取值：
     * normal：正常图片，无标签
     * tag：含标签的图片
     */
    private String label;
    /**
     * 建议用户执行的操作，取值：
     * pass：图片不含标签，无需进行其余操作
     * review：图片含标签，建议执行后续操作
     */
    private String suggestion;
    /**
     * 结果为该分类的概率，取值范围为[0.00-100.00]。值越高，表示越有可能属于该分类。
     */
    private Double rate;
    /**
     * 标签识别发现标签时（label=tag），返回的标签数据信息。具体结构描述见tagData。
     */
    private TagDataDTO tagData;
    /**
     * 命中的相似图结果。返回被检测图片与样本图库中所有图片比对后，相似度高的结果记录。
     */
    private List<SimilarityImageDTO> similarityImageData;
}
