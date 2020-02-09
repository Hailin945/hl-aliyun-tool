package com.chinavisionary.tools.aliyun.green.common.util;

import com.aliyuncs.AcsRequest;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.ProtocolType;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;

/**
 * @author Hailin
 * @date 2019/12/18
 */
public class RequestUtil {

    private static final Integer DEFAULT_CONNECT_TIMEOUT = 3000;

    private static final Integer DEFAULT_READ_TIMEOUT = 10000;

    public static void setRequest(AcsRequest<? extends AcsResponse> request) {
        setRequest(request, null, null, null);
    }

    public static void setRequest(AcsRequest<? extends AcsResponse> request, ProtocolType protocolType) {
        setRequest(request, null, null, protocolType);
    }

    public static void setRequest(
            AcsRequest<? extends AcsResponse> request, Integer connectTimeout, Integer readTimeout) {
        setRequest(request, connectTimeout, readTimeout, null);
    }

    public static void setRequest(
            AcsRequest<? extends AcsResponse> request,
            Integer connectTimeout, Integer readTimeout, ProtocolType protocolType) {
        // 指定api返回格式
        request.setAcceptFormat(FormatType.JSON);
        request.setEncoding("utf-8");
        request.setRegionId(RegionGreenEnum.CN_SHANGHAI.getCode());
        request.setHttpContentType(FormatType.JSON);
        // 设置超时时间
        if (connectTimeout == null) {
            request.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT);
        } else {
            request.setConnectTimeout(connectTimeout);
        }
        if (readTimeout == null) {
            request.setReadTimeout(DEFAULT_READ_TIMEOUT);
        } else {
            request.setReadTimeout(readTimeout);
        }
        if (protocolType == null) {
            request.setProtocol(ProtocolType.HTTP);
        } else {
            request.setProtocol(protocolType);
        }
    }
}
