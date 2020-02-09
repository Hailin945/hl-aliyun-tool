package com.chinavisionary.tools.aliyun.green.text.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.green.model.v20180509.TextScanRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.chinavisionary.tools.aliyun.green.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.common.util.RequestUtil;
import com.chinavisionary.tools.aliyun.green.text.dto.TextScanDTO;
import com.chinavisionary.tools.aliyun.green.text.param.TextScanParam;
import com.chinavisionary.tools.aliyun.green.text.service.TextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/19
 */
@Service
@Slf4j
public class TextServiceImpl implements TextService {

    @Resource
    private ClientFactory clientFactory;

    @Override
    @SuppressWarnings("unchecked")
    public DataResult<List<TextScanDTO>> textScan(TextScanParam param) {
        try {
            IAcsClient client = clientFactory.getClient(RegionGreenEnum.CN_SHANGHAI);

            TextScanRequest textScanRequest = new TextScanRequest();
            RequestUtil.setRequest(textScanRequest, 3000, 6000);

            textScanRequest.setHttpContent(
                    JSON.toJSONString(param).getBytes(StandardCharsets.UTF_8), "UTF-8", FormatType.JSON);

            HttpResponse httpResponse = client.doAction(textScanRequest);

            if (!httpResponse.isSuccess()) {
                return new DataResult<>(false, "响应失败", String.valueOf(httpResponse.getStatus()));
            }
            JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), StandardCharsets.UTF_8));
            log.debug(JSON.toJSONString(scrResponse, true));
            DataResult<List<TextScanDTO>> dataResult = scrResponse.toJavaObject(DataResult.class);
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
}
