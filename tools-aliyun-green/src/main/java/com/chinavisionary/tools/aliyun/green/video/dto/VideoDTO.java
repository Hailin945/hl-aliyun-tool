package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@Data
public class VideoDTO {

    /**
     * 数据Id。需要保证在一次请求中Id不重复。
     */
    private String dataId;
    /**
     * 截帧地址的前缀。截帧的完整URL为：framePrefix + frame.url
     */
    private String framePrefix;
    /**
     * 图片序列的截帧信息。frames中的每个元素是个结构体
     */
    private List<FrameDTO> frames;
    /**
     * 视频截帧间隔，单位为秒，取值范围为[1, 60]。默认值为1秒。
     */
    private Integer interval;
    /**
     * 待检测视频的URL
     */
    private String url;
}
