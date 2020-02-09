package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@Data
public class FrameDTO {

    /**
     * 截帧地址。
     */
    private String url;
    /**
     * 该截帧距离片头的时间戳，单位为秒。
     */
    private Integer offset;
    /**
     * 该视频截帧的风险分类，
     */
    private String label;
    /**
     * 该视频截帧结果为label所述分类的概率，取值范围为[0.00-100.00]。值越高，表示越有可能属于该分类。
     */
    private Double rate;
    /**
     * 识别出来的人脸信息列表，具体结构描述见sfaceData。
     */
    private List<SfaceInfoDTO> sfaceData;
}
