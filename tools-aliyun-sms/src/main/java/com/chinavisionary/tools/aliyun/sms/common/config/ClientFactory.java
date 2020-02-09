package com.chinavisionary.tools.aliyun.sms.common.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunRegionEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Hailin
 * @date 2019/12/9
 */
@Component
public class ClientFactory {

    @Resource
    private AccessKeyConfig accessKeyConfig;

    /**
     * 获取阿里云请求客户端对象
     *
     * @param accessKeyId     访问密钥 ID。AccessKey 用于调用 API。
     * @param accessKeySecret 用来验证用户的密钥
     * @param regionEnum      API支持的RegionID
     * @return 阿里云请求客户端对象
     */
    public IAcsClient getClient(AliyunRegionEnum regionEnum, String accessKeyId, String accessKeySecret) {
        if (StringUtils.isBlank(accessKeyId)) {
            accessKeyId = accessKeyConfig.getAccessKeyId();
        }
        if (StringUtils.isBlank(accessKeySecret)) {
            accessKeySecret = accessKeyConfig.getAccessKeySecret();
        }
        DefaultProfile profile = DefaultProfile.getProfile(regionEnum.getCode(), accessKeyId, accessKeySecret);
        return new DefaultAcsClient(profile);
    }
}
