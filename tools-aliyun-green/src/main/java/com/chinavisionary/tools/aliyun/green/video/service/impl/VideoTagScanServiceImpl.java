package com.chinavisionary.tools.aliyun.green.video.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.green.model.v20180509.VideoAsyncScanRequest;
import com.aliyuncs.green.model.v20180509.VideoAsyncScanResultsRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.chinavisionary.tools.aliyun.green.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.green.common.constants.GreenSceneEnum;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.common.util.RequestUtil;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.video.dto.VideoTagTaskDTO;
import com.chinavisionary.tools.aliyun.green.video.param.VideoTagAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.video.service.VideoScanService;
import com.chinavisionary.tools.aliyun.green.video.service.VideoTagScanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/21
 */
@Service
public class VideoTagScanServiceImpl implements VideoTagScanService {

    @Resource
    private ClientFactory clientFactory;
    @Resource
    private VideoScanService videoScanService;

    @Override
    public DataResult<List<VideoTagAsyncScanDTO>> async(List<VideoTagTaskDTO> tasks) {
        VideoTagAsyncScanParam param = new VideoTagAsyncScanParam();
        List<String> scenes = new ArrayList<>(1);
        scenes.add(GreenSceneEnum.IMAGE_TAG.getCode());
        param.setScenes(scenes);
        param.setTasks(tasks);
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            VideoAsyncScanRequest videoAsyncScanRequest = new VideoAsyncScanRequest();
            RequestUtil.setRequest(videoAsyncScanRequest);

            videoAsyncScanRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(videoAsyncScanRequest);
            JSONObject jo = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            System.out.println(JSON.toJSONString(jo, true));
            return jo.toJavaObject(new TypeReference<DataResult<List<VideoTagAsyncScanDTO>>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }

    @Override
    public DataResult<List<VideoTagAsyncScanResultDTO>> getAsyncResult(List<String> taskIds) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            VideoAsyncScanResultsRequest videoAsyncScanResultsRequest = new VideoAsyncScanResultsRequest();
            RequestUtil.setRequest(videoAsyncScanResultsRequest);

            videoAsyncScanResultsRequest.setHttpContent(
                    JSON.toJSONString(taskIds).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(videoAsyncScanResultsRequest);
            JSONObject jo = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            System.out.println(JSON.toJSONString(jo, true));
            return jo.toJavaObject(new TypeReference<DataResult<List<VideoTagAsyncScanResultDTO>>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }
}
