package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

/**
 * 识别出的人脸信息
 *
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class FaceDTO {

    /**
     * 相似人物的名称
     */
    private String name;
    /**
     * 相似概率
     */
    private Double rate;
    /**
     * 人脸Id
     */
    private String id;
    /**
     * 是否少数民族
     */
    private Boolean minority;
}
