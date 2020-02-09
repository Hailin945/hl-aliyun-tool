package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@Data
public class VideoScanResultDTO {

    private Double rate;
    private String suggestion;
    private String label;
    private String scene;
    /**
     * 图片序列的截帧信息。frames中的每个元素是个结构体
     */
    private List<FrameDTO> frames;
}
