package com.chinavisionary.tools.aliyun.green.video.param;

import com.chinavisionary.tools.aliyun.green.video.dto.VideoDTO;
import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@Data
public class VideoFaceSyncScanParam {

    /**
     * 待检测视频的URL
     */
    private List<VideoDTO> tasks;
}
