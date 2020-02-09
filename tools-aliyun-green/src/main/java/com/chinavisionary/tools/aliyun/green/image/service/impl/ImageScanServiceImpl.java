package com.chinavisionary.tools.aliyun.green.image.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.green.model.v20180509.ImageAsyncScanRequest;
import com.aliyuncs.green.model.v20180509.ImageAsyncScanResultsRequest;
import com.aliyuncs.green.model.v20180509.ImageSyncScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.chinavisionary.tools.aliyun.green.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.green.common.constants.GreenSceneEnum;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.common.util.RequestUtil;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageSyncScanDTO;
import com.chinavisionary.tools.aliyun.green.image.param.*;
import com.chinavisionary.tools.aliyun.green.image.service.ImageScanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/17
 */
@Service
@Slf4j
public class ImageScanServiceImpl implements ImageScanService {

    @Resource
    private ClientFactory clientFactory;

    @Override
    public DataResult<List<ImageSyncScanDTO>> imageSyncScan(ImageSyncScanParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            ImageSyncScanRequest imageSyncScanRequest = new ImageSyncScanRequest();
            RequestUtil.setRequest(imageSyncScanRequest);
            imageSyncScanRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(imageSyncScanRequest);
            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.info(JSON.toJSONString(scrResponse, true));
            return scrResponse.toJavaObject(new TypeReference<DataResult<List<ImageSyncScanDTO>>>(){});
        } catch (ClientException e) {
            e.printStackTrace();
            return new DataResult<>(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "系统异常");
    }

    @Override
    public DataResult<List<ImageSyncScanDTO>> imageSyncScan(List<String> imageUrlList, List<GreenSceneEnum> sceneEnumList) {
        ImageSyncScanParam param = new ImageSyncScanParam();
        List<ImageParam> tasks = new ArrayList<>(10);
        imageUrlList.forEach(url -> {
            ImageParam imageParam = ImageParam.init();
            imageParam.setUrl(url);
            tasks.add(imageParam);
        });
        param.setTasks(tasks);

        List<String> scenes = new ArrayList<>(16);
        sceneEnumList.forEach(scene -> scenes.add(scene.getCode()));
        param.setScenes(scenes);
        return this.imageSyncScan(param);
    }

    @Override
    public DataResult<List<ImageSyncScanDTO>> imageSyncScanSimilarity(List<ImageSyncScanSimilarityParam> paramList) {
        ImageSyncScanParam param = new ImageSyncScanParam();
        List<String> scenes = new ArrayList<>(1);
        scenes.add(GreenSceneEnum.IMAGE_SIMILARITY.getCode());
        param.setScenes(scenes);
        List<ImageParam> tasks = new ArrayList<>(10);
        paramList.forEach(p -> {
            ImageParam imageParam = new ImageParam();
            imageParam.setUrl(p.getUrl());
            imageParam.setDataId(p.getDataId());
            imageParam.setSimilarityLibraries(p.getSimilarityLibraries());
            tasks.add(imageParam);
        });
        param.setTasks(tasks);
        return this.imageSyncScan(param);
    }

    @Override
    public DataResult<List<ImageAsyncScanDTO>> imageAsyncScan(ImageAsyncScanParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            ImageAsyncScanRequest imageAsyncScanRequest = new ImageAsyncScanRequest();
            RequestUtil.setRequest(imageAsyncScanRequest, 3000, 6000);

            imageAsyncScanRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(imageAsyncScanRequest);
            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.info(JSON.toJSONString(scrResponse, true));
            DataResult<List<ImageAsyncScanDTO>> dataResult =
                    scrResponse.toJavaObject(new TypeReference<DataResult<List<ImageAsyncScanDTO>>>(){});
            dataResult.setSuccess(true);
            return dataResult;
        } catch (ClientException e) {
            e.printStackTrace();
            return new DataResult<>(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "系统异常");
    }

    @Override
    public DataResult<List<ImageAsyncScanResultDTO>> imageAsyncScanResult(ImageAsyncScanResultParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            ImageAsyncScanResultsRequest imageAsyncScanResultsRequest = new ImageAsyncScanResultsRequest();
            RequestUtil.setRequest(imageAsyncScanResultsRequest, 3000, 6000);

            imageAsyncScanResultsRequest.setHttpContent(
                    JSON.toJSONString(param.getTaskIdList()).getBytes(StandardCharsets.UTF_8),
                    "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(imageAsyncScanResultsRequest);
            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.info(JSON.toJSONString(scrResponse, true));
            DataResult<List<ImageAsyncScanResultDTO>> dataResult =
                    scrResponse.toJavaObject(new TypeReference<DataResult<List<ImageAsyncScanResultDTO>>>(){});
            dataResult.setSuccess(true);
            return dataResult;
        } catch (ClientException e) {
            e.printStackTrace();
            return new DataResult<>(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "系统异常");
    }

    @Override
    public DataResult<List<ImageAsyncScanResultDTO>> imageAsyncScanResult(List<String> taskIdList) {
        ImageAsyncScanResultParam param = new ImageAsyncScanResultParam();
        param.setTaskIdList(taskIdList);
        return this.imageAsyncScanResult(param);
    }
}
