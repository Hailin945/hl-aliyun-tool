package com.chinavisionary.tools.aliyun.green.video.service.impl;

import com.chinavisionary.tools.aliyun.green.common.constants.GreenSceneEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoResultDTO;
import com.chinavisionary.tools.aliyun.green.video.param.VideoAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.param.VideoFaceAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.param.VideoFaceSyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.param.VideoSyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.service.VideoFaceScanService;
import com.chinavisionary.tools.aliyun.green.video.service.VideoScanService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/21
 */
@Service
public class VideoFaceScanServiceImpl implements VideoFaceScanService {

    @Resource
    private VideoScanService videoScanService;

    @Override
    public DataResult<List<VideoResultDTO>> sync(VideoFaceSyncScanParam param) {
        VideoSyncScanParam videoSyncScanParam = new VideoSyncScanParam();
        BeanUtils.copyProperties(param, videoSyncScanParam);
        videoSyncScanParam.setScenes(createFaceScene());
        return videoScanService.sync(videoSyncScanParam);
    }

    @Override
    public DataResult<List<VideoResultDTO>> async(VideoFaceAsyncScanParam param) {
        VideoAsyncScanParam videoAsyncScanParam = new VideoAsyncScanParam();
        BeanUtils.copyProperties(param, videoAsyncScanParam);
        videoAsyncScanParam.setScenes(createFaceScene());
        return videoScanService.async(videoAsyncScanParam);
    }

    private List<String> createFaceScene() {
        List<String> scenes = new ArrayList<>(1);
        scenes.add(GreenSceneEnum.IMAGE_SFACE.getCode());
        return scenes;
    }
}
