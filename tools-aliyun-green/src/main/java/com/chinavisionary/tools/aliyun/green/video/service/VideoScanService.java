package com.chinavisionary.tools.aliyun.green.video.service;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoResultDTO;
import com.chinavisionary.tools.aliyun.green.video.param.VideoAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.param.VideoSyncScanParam;

import java.util.List;

/**
 * 视频检测
 *
 * @author Hailin
 * @date 2019/12/20
 */
public interface VideoScanService {

    /**
     * 视频同步检测
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<VideoResultDTO>> sync(VideoSyncScanParam param);

    /**
     * 视频异步检测
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<VideoResultDTO>> async(VideoAsyncScanParam param);
}
