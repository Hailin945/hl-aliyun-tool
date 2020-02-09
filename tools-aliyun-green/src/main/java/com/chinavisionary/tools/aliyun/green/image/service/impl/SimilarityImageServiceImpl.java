package com.chinavisionary.tools.aliyun.green.image.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.green.model.v20180509.AddSimilarityImageRequest;
import com.aliyuncs.green.model.v20180509.DeleteSimilarityImageRequest;
import com.aliyuncs.green.model.v20180509.GetSimilarityImageRequest;
import com.aliyuncs.green.model.v20180509.ListSimilarityImagesRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.chinavisionary.tools.aliyun.green.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.common.util.RequestUtil;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageDTO;
import com.chinavisionary.tools.aliyun.green.image.param.ImageParam;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityImageListDTO;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityImageCreateParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityImageDeleteParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityImageGetParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityImageListParam;
import com.chinavisionary.tools.aliyun.green.image.service.SimilarityImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@Service
@Slf4j
public class SimilarityImageServiceImpl implements SimilarityImageService {

    @Resource
    private ClientFactory clientFactory;

    @Override
    public DataResult<List<ImageDTO>> create(SimilarityImageCreateParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            AddSimilarityImageRequest addSimilarityImageRequest = new AddSimilarityImageRequest();
            RequestUtil.setRequest(addSimilarityImageRequest);

            addSimilarityImageRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(addSimilarityImageRequest);

            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            DataResult<List<ImageDTO>> dataResult =
                    scrResponse.toJavaObject(new TypeReference<DataResult<List<ImageDTO>>>(){});
            dataResult.setSuccess(true);
            return dataResult;
        } catch (ClientException e) {
            e.printStackTrace();
            return new DataResult<>(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }

    @Override
    public DataResult<List<ImageParam>> delete(SimilarityImageDeleteParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            DeleteSimilarityImageRequest deleteSimilarityImageRequest = new DeleteSimilarityImageRequest();
            RequestUtil.setRequest(deleteSimilarityImageRequest);

            deleteSimilarityImageRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(deleteSimilarityImageRequest);

            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            DataResult<List<ImageParam>> dataResult =
                    scrResponse.toJavaObject(new TypeReference<DataResult<List<ImageParam>>>(){});
            dataResult.setSuccess(true);
            return dataResult;
        } catch (ClientException e) {
            e.printStackTrace();
            return new DataResult<>(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }

    @Override
    public DataResult<ImageParam> get(SimilarityImageGetParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            GetSimilarityImageRequest getSimilarityImageRequest = new GetSimilarityImageRequest();
            RequestUtil.setRequest(getSimilarityImageRequest);

            getSimilarityImageRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(getSimilarityImageRequest);

            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            DataResult<ImageParam> dataResult =
                    scrResponse.toJavaObject(new TypeReference<DataResult<ImageParam>>(){});
            dataResult.setSuccess(true);
            return dataResult;
        } catch (ClientException e) {
            e.printStackTrace();
            return new DataResult<>(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DataResult<>(false, "内部异常");
    }

    @Override
    public SimilarityImageListDTO list(SimilarityImageListParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            ListSimilarityImagesRequest listSimilarityImagesRequest = new ListSimilarityImagesRequest();
            RequestUtil.setRequest(listSimilarityImagesRequest);

            listSimilarityImagesRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(listSimilarityImagesRequest);

            if (!httpResponse.isSuccess()) {
                return new SimilarityImageListDTO(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            SimilarityImageListDTO similarityImageListDTO = scrResponse.toJavaObject(SimilarityImageListDTO.class);
            similarityImageListDTO.setSuccess(true);
            return similarityImageListDTO;
        } catch (ClientException e) {
            e.printStackTrace();
            return new SimilarityImageListDTO(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimilarityImageListDTO(false, "内部异常");
    }
}
