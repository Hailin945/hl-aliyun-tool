package com.chinavisionary.tools.aliyun.green.image.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.green.model.v20180509.AddSimilarityLibraryRequest;
import com.aliyuncs.green.model.v20180509.DeleteSimilarityLibraryRequest;
import com.aliyuncs.green.model.v20180509.GetSimilarityLibraryRequest;
import com.aliyuncs.green.model.v20180509.ListSimilarityLibrariesRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.chinavisionary.tools.aliyun.green.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.Result;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.common.util.RequestUtil;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityLibraryDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityLibraryListDTO;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityLibraryCreateParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityLibraryDeleteParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityLibraryGetParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityLibraryListParam;
import com.chinavisionary.tools.aliyun.green.image.service.SimilarityLibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@Service
@Slf4j
public class SimilarityLibraryServiceImpl implements SimilarityLibraryService {

    @Resource
    private ClientFactory clientFactory;

    @Override
    @SuppressWarnings("unchecked")
    public DataResult<SimilarityLibraryDTO> create(SimilarityLibraryCreateParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            AddSimilarityLibraryRequest addSimilarityLibraryRequest = new AddSimilarityLibraryRequest();
            RequestUtil.setRequest(addSimilarityLibraryRequest);

            addSimilarityLibraryRequest.setHttpContent(
                    JSONObject.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(addSimilarityLibraryRequest);

            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            DataResult<SimilarityLibraryDTO> dataResult =
                    scrResponse.toJavaObject(new TypeReference<DataResult<SimilarityLibraryDTO>>(){});
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
    public DataResult<SimilarityLibraryDTO> create(String name) {
        SimilarityLibraryCreateParam param = new SimilarityLibraryCreateParam();
        param.setName(name);
        return this.create(param);
    }

    @Override
    public Result delete(SimilarityLibraryDeleteParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            DeleteSimilarityLibraryRequest deleteSimilarityLibraryRequest = new DeleteSimilarityLibraryRequest();
            RequestUtil.setRequest(deleteSimilarityLibraryRequest);

            deleteSimilarityLibraryRequest.setHttpContent(
                    JSONObject.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(deleteSimilarityLibraryRequest);

            if (!httpResponse.isSuccess()) {
                return new Result(false, "响应失败", null, String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            Result result = scrResponse.toJavaObject(Result.class);
            result.setSuccess(true);
            return result;
        } catch (ClientException e) {
            e.printStackTrace();
            return new Result(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "内部异常");
    }

    @Override
    public Result delete(String name) {
        SimilarityLibraryDeleteParam param = new SimilarityLibraryDeleteParam();
        param.setName(name);
        return this.delete(param);
    }

    @Override
    @SuppressWarnings("unchecked")
    public DataResult<SimilarityLibraryDTO> get(SimilarityLibraryGetParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            GetSimilarityLibraryRequest getSimilarityLibraryRequest = new GetSimilarityLibraryRequest();
            RequestUtil.setRequest(getSimilarityLibraryRequest);

            getSimilarityLibraryRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(getSimilarityLibraryRequest);
            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            DataResult<SimilarityLibraryDTO> dataResult =
                    scrResponse.toJavaObject(new TypeReference<DataResult<SimilarityLibraryDTO>>(){});
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
    public DataResult<SimilarityLibraryDTO> get(String name) {
        SimilarityLibraryGetParam param = new SimilarityLibraryGetParam();
        param.setName(name);
        return this.get(param);
    }

    @Override
    public SimilarityLibraryListDTO list(SimilarityLibraryListParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            ListSimilarityLibrariesRequest listSimilarityLibrariesRequest = new ListSimilarityLibrariesRequest();
            RequestUtil.setRequest(listSimilarityLibrariesRequest);

            listSimilarityLibrariesRequest.setHttpContent(
                   JSONObject.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(listSimilarityLibrariesRequest);
            if (!httpResponse.isSuccess()) {
                return new SimilarityLibraryListDTO(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            SimilarityLibraryListDTO similarityLibraryListDTO = scrResponse.toJavaObject(SimilarityLibraryListDTO.class);
            similarityLibraryListDTO.setSuccess(true);
            return similarityLibraryListDTO;
        } catch (ClientException e) {
            e.printStackTrace();
            return new SimilarityLibraryListDTO(false, "创建连接失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimilarityLibraryListDTO(false, "内部异常");
    }

    @Override
    public SimilarityLibraryListDTO list(Integer pageSize, Integer currentPage) {
        SimilarityLibraryListParam param = new SimilarityLibraryListParam();
        param.setPageSize(pageSize);
        param.setCurrentPage(currentPage);
        return this.list(param);
    }
}
