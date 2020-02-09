package com.chinavisionary.tools.aliyun.green.video.dto;

import com.chinavisionary.tools.aliyun.green.image.dto.TagDataDTO;
import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class VideoTagScanResultDTO {

    private Double rate;
    private String suggestion;
    private String label;
    private String scene;
    private TagDataDTO tagData;
}
