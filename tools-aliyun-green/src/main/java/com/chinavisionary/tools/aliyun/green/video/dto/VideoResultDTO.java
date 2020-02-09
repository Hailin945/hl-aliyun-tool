package com.chinavisionary.tools.aliyun.green.video.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VideoResultDTO extends VideoDTO {

    /**
     * 错误码，和HTTP的status code一致。
     */
    private String code;
    /**
     * 错误描述信息。
     */
    private String msg;
    /**
     * 该检测任务的ID。
     */
    private String taskId;
    /**
     * 返回结果，调用成功时（code=200），返回结果中包含一个或多个元素。
     */
    private List<VideoScanResultDTO> results;
}
