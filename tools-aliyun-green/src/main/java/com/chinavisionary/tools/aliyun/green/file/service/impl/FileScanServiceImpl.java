package com.chinavisionary.tools.aliyun.green.file.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.green.model.v20180509.FileAsyncScanRequest;
import com.aliyuncs.green.model.v20180509.FileAsyncScanResultsRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.chinavisionary.tools.aliyun.green.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.common.util.RequestUtil;
import com.chinavisionary.tools.aliyun.green.file.dto.FileAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.file.dto.FileAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.file.param.FileAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.file.service.FileScanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/23
 */
@Service
@Slf4j
public class FileScanServiceImpl implements FileScanService {

    @Resource
    private ClientFactory clientFactory;

    @Override
    public DataResult<List<FileAsyncScanDTO>> async(FileAsyncScanParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            FileAsyncScanRequest asyncScanRequest = new FileAsyncScanRequest();
            RequestUtil.setRequest(asyncScanRequest, 3000, 6000);

            asyncScanRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);
            log.debug("\n{}", JSON.toJSONString(param, true));

            HttpResponse httpResponse = client.doAction(asyncScanRequest);

            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug("\n{}", JSON.toJSONString(scrResponse, true));
            return scrResponse.toJavaObject(new TypeReference<DataResult<List<FileAsyncScanDTO>>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }

    @Override
    public DataResult<List<FileAsyncScanResultDTO>> getAsyncResult(List<String> taskIds) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);
            FileAsyncScanResultsRequest getResultsRequest = new FileAsyncScanResultsRequest();
            RequestUtil.setRequest(getResultsRequest, 3000, 6000);
            getResultsRequest.setHttpContent(
                    JSON.toJSONString(taskIds).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(getResultsRequest);

            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug("\n{}", JSON.toJSONString(scrResponse, true));
            return scrResponse.toJavaObject(new TypeReference<DataResult<List<FileAsyncScanResultDTO>>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }
}
