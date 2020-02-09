package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@Data
public class SfaceInfoDTO {

    /**
     * 年龄
     */
    private Double age;
    /**
     * 性别
     */
    private String gender;
    /**
     * 识别出的人脸信息
     */
    private List<FaceDTO> faces;
    /**
     * 是否戴眼镜。
     */
    private Boolean glasses;
    /**
     * 是否亚裔
     */
    private Boolean asian;
}
