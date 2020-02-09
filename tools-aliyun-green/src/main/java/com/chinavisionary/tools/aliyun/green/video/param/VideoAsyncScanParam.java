package com.chinavisionary.tools.aliyun.green.video.param;

import com.chinavisionary.tools.aliyun.green.common.constants.GreenSceneEnum;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoDTO;
import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@Data
public class VideoAsyncScanParam {

    /**
     * 待检测视频的URL
     */
    private List<VideoDTO> tasks;
    /**
     * 指定视频检测的应用场景
     * @see GreenSceneEnum
     */
    private List<String> scenes;
}
