package com.chinavisionary.tools.aliyun.green.video.service;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagTaskDTO;

import java.util.List;

/**
 * 视频标签识别
 *
 * @author Hailin
 * @date 2019/12/21
 */
public interface VideoTagScanService {

    /**
     * 视频标签识别
     *
     * @param tasks 请求参数
     * @return 返回结果
     */
    DataResult<List<VideoTagAsyncScanDTO>> async(List<VideoTagTaskDTO> tasks);

    /**
     * 查询视频异步检测结果
     *
     * @param taskIds 要查询的taskId列表。最大长度不超过100。
     * @return 返回结果
     */
    DataResult<List<VideoTagAsyncScanResultDTO>> getAsyncResult(List<String> taskIds);
}
