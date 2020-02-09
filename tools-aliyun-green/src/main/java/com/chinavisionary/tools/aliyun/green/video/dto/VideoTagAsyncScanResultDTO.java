package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;

import java.util.List;

/**
 * 视频标签识别数据传输对象
 *
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class VideoTagAsyncScanResultDTO {

    /**
     * 错误码，和HTTP的status code一致。
     */
    private String code;
    /**
     * 错误描述信息。
     */
    private String msg;
    /**
     * 错误描述信息。
     */
    private String dataId;
    /**
     * 错误描述信息。
     */
    private String taskId;

    private List<VideoTagScanResultDTO> results;
}
