package com.chinavisionary.tools.aliyun.green.file.service;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.file.dto.FileAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.file.dto.FileAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.file.param.FileAsyncScanParam;

import java.util.List;

/**
 * 文件检测
 *
 * @author Hailin
 * @date 2019/12/23
 */
public interface FileScanService {

    DataResult<List<FileAsyncScanDTO>> async(FileAsyncScanParam param);

    DataResult<List<FileAsyncScanResultDTO>> getAsyncResult(List<String> taskIds);
}
