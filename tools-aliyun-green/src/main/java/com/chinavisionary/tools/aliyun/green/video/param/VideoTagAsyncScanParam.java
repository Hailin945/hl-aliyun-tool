package com.chinavisionary.tools.aliyun.green.video.param;

import com.chinavisionary.tools.aliyun.green.common.constants.GreenSceneEnum;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagTaskDTO;
import lombok.Data;

import java.util.List;

/**
 * 视频标签识别
 *
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class VideoTagAsyncScanParam {

    /**
     * 该字段用于标识业务场景。
     * 针对不同的业务场景，您可以配置不同的内容审核策略，以满足不同场景下不同的审核标准或算法策略的需求。
     * 您可以通过云盾内容安全控制台创建业务场景（bizType），或者通过工单联系我们帮助您创建业务场景。
     */
    private String bizType;
    /**
     * 指定视频检测的应用场景
     *
     * @see GreenSceneEnum
     */
    private List<String> scenes;
    /**
     * 待检测视频
     */
    private List<VideoTagTaskDTO> tasks;
}
