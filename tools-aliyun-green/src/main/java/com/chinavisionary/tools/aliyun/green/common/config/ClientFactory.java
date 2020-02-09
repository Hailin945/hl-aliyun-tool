package com.chinavisionary.tools.aliyun.green.common.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
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
    public IAcsClient getClient(RegionGreenEnum regionEnum, String accessKeyId, String accessKeySecret)
            throws ClientException {
        String regionId = regionEnum.getCode();
        if (StringUtils.isBlank(regionId)) {
            regionId = accessKeyConfig.getRegionId();
        }
        if (StringUtils.isBlank(regionId)) {
            regionId = RegionGreenEnum.CN_SHANGHAI.getCode();
        }
        if (StringUtils.isBlank(accessKeyId)) {
            accessKeyId = accessKeyConfig.getAccessKeyId();
        }
        if (StringUtils.isBlank(accessKeySecret)) {
            accessKeySecret = accessKeyConfig.getAccessKeySecret();
        }
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);

        DefaultProfile.addEndpoint(regionId, regionId, "Green", getDomain(RegionGreenEnum.getByCode(regionId)));
        return new DefaultAcsClient(profile);
    }

    /**
     * 获取阿里云请求客户端对象
     *
     * @param regionEnum API支持的地域
     * @return 阿里云请求客户端对象
     */
    public IAcsClient getClient(RegionGreenEnum regionEnum) throws ClientException {
        return this.getClient(regionEnum, null, null);
    }

    private String getDomain(RegionGreenEnum regionEnum) {
        switch (regionEnum) {
            case CN_BEIJING:
                return "green.cn-beijing.aliyuncs.com";
            case AP_SOUTHEAST_1:
                return "green.ap-southeast-1.aliyuncs.com";
            case US_WEST_1:
                return "green.us-west-1.aliyuncs.com";
            default:
                return "green.cn-shanghai.aliyuncs.com";
        }
    }
}
