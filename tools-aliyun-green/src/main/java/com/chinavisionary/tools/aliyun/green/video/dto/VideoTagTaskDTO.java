package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class VideoTagTaskDTO {

    /**
     * 数据Id。需要保证在一次请求中Id不重复。
     */
    private String dataId;
    /**
     * 待检测视频的URL
     */
    private String url;
}
