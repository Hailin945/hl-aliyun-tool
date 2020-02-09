package com.chinavisionary.tools.aliyun.green.video.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.green.model.v20180509.VideoAsyncScanRequest;
import com.aliyuncs.green.model.v20180509.VideoSyncScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.chinavisionary.tools.aliyun.green.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.common.util.RequestUtil;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoResultDTO;
import com.chinavisionary.tools.aliyun.green.video.param.VideoAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.param.VideoSyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.service.VideoScanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/20
 */
@Service
public class VideoScanServiceImpl implements VideoScanService {

    @Resource
    private ClientFactory clientFactory;

    @Override
    public DataResult<List<VideoResultDTO>> sync(VideoSyncScanParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            VideoSyncScanRequest videoSyncScanRequest = new VideoSyncScanRequest();
            RequestUtil.setRequest(videoSyncScanRequest);

            videoSyncScanRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(videoSyncScanRequest);

            if (httpResponse.isSuccess()) {
                JSONObject jo = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
                System.out.println(JSON.toJSONString(jo, true));
                return jo.toJavaObject(new TypeReference<DataResult<List<VideoResultDTO>>>() {
                });
            } else {
                System.out.println("response not success. status:" + httpResponse.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }

    @Override
    public DataResult<List<VideoResultDTO>> async(VideoAsyncScanParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            VideoAsyncScanRequest videoAsyncScanRequest = new VideoAsyncScanRequest();
            RequestUtil.setRequest(videoAsyncScanRequest);

            videoAsyncScanRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(videoAsyncScanRequest);
            JSONObject jo = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            System.out.println(JSON.toJSONString(jo, true));
            return jo.toJavaObject(new TypeReference<DataResult<List<VideoResultDTO>>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }
}
