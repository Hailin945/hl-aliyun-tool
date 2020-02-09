package com.chinavisionary.tools.aliyun.green.video.param;

import com.chinavisionary.tools.aliyun.green.video.dto.VideoDTO;
import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class VideoFaceAsyncScanParam {

    /**
     * 待检测视频的URL
     */
    private List<VideoDTO> tasks;
}
