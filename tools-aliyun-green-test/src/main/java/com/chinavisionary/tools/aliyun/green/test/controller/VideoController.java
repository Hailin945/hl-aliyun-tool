package com.chinavisionary.tools.aliyun.green.test.controller;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoResultDTO;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagTaskDTO;
import com.chinavisionary.tools.aliyun.green.video.param.VideoAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.param.VideoSyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.service.VideoScanService;
import com.chinavisionary.tools.aliyun.green.video.service.VideoTagScanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@RestController
@RequestMapping("/v1/video")
public class VideoController {

    @Resource
    private VideoScanService videoScanService;
    @Resource
    private VideoTagScanService videoTagScanService;

    @PostMapping("/scan/sync")
    public DataResult<List<VideoResultDTO>> syncScan(@RequestBody VideoSyncScanParam param) {
        return videoScanService.sync(param);
    }

    @PostMapping("/scan/async")
    public DataResult<List<VideoResultDTO>> asyncScan(@RequestBody VideoAsyncScanParam param) {
        return videoScanService.async(param);
    }

    @PostMapping("/scan/tag/async")
    public DataResult<List<VideoTagAsyncScanDTO>> videoTagAsyncScan(@RequestBody List<VideoTagTaskDTO> tasks) {
        return videoTagScanService.async(tasks);
    }

    @PostMapping("/scan/tag/async/result")
    public DataResult<List<VideoTagAsyncScanResultDTO>> getVideoTagAsyncScanResult(@RequestBody List<String> taskIds) {
        return videoTagScanService.getAsyncResult(taskIds);
    }
}
