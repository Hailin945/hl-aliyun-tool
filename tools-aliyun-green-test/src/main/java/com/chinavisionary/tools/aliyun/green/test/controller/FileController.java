package com.chinavisionary.tools.aliyun.green.test.controller;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.file.dto.FileAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.file.dto.FileAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.file.param.FileAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.file.service.FileScanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/23
 */
@RestController
@RequestMapping("/v1/file")
public class FileController {

    @Resource
    private FileScanService fileScanService;

    @PostMapping("/async")
    public DataResult<List<FileAsyncScanDTO>> async(@RequestBody FileAsyncScanParam param) {
        return fileScanService.async(param);
    }

    @PostMapping("/async/result")
    public DataResult<List<FileAsyncScanResultDTO>> async(@RequestBody List<String> taskIds) {
        return fileScanService.getAsyncResult(taskIds);
    }
}
