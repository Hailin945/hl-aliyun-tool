package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class VideoTagDataDTO {

    private List<VideoTagSummaryDTO> summary;

    private List<VideoTagDetailDTO> details;
}
