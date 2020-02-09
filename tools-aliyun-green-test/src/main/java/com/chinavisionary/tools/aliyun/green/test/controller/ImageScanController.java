package com.chinavisionary.tools.aliyun.green.test.controller;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageSyncScanDTO;
import com.chinavisionary.tools.aliyun.green.image.param.ImageAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.image.param.ImageSyncScanParam;
import com.chinavisionary.tools.aliyun.green.image.param.ImageSyncScanSimilarityParam;
import com.chinavisionary.tools.aliyun.green.image.service.ImageScanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/17
 */
@RestController
@RequestMapping("/v1/image/scan")
public class ImageScanController {

    @Resource
    private ImageScanService imageScanService;

    @PostMapping("/sync")
    public DataResult<List<ImageSyncScanDTO>> imageSyncScan(@RequestBody ImageSyncScanParam param) {
        return imageScanService.imageSyncScan(param);
    }

    @PostMapping("/sync/similarity")
    public DataResult<List<ImageSyncScanDTO>> imageSyncScan(@RequestBody List<ImageSyncScanSimilarityParam> param) {
        return imageScanService.imageSyncScanSimilarity(param);
    }

    @PostMapping("/async")
    public DataResult<List<ImageAsyncScanDTO>> imageAsyncScan(@RequestBody ImageAsyncScanParam param) {
        return imageScanService.imageAsyncScan(param);
    }

    @PostMapping("/async/result")
    public DataResult<List<ImageAsyncScanResultDTO>> imageAsyncScan(@RequestBody List<String> taskIdList) {
        return imageScanService.imageAsyncScanResult(taskIdList);
    }
}
