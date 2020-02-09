package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class VideoTagDetailDTO {

    private String cnCategory;
    private String enCategory;
    private String tagEnName;
    private String tagCnName;
    private List<VideoTagSegment> tagSegment;
}
