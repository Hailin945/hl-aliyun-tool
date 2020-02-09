package com.chinavisionary.tools.aliyun.green.video.service;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoResultDTO;
import com.chinavisionary.tools.aliyun.green.video.param.VideoFaceAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.param.VideoFaceSyncScanParam;

import java.util.List;

/**
 * 视频敏感人脸识别
 *
 * @author Hailin
 * @date 2019/12/21
 */
public interface VideoFaceScanService {

    /**
     * 同步检测
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<VideoResultDTO>> sync(VideoFaceSyncScanParam param);

    /**
     * 异步检测
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<VideoResultDTO>> async(VideoFaceAsyncScanParam param);
}
