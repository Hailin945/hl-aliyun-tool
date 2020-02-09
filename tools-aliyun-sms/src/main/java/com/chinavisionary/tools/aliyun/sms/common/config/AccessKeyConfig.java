package com.chinavisionary.tools.aliyun.sms.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云访问密钥，AccessKey用于程序方式调用服务API
 *
 * @author Hailin
 * @date 2019/12/9
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.ak.sms")
public class AccessKeyConfig {
    /**
     * 用于标识用户
     */
    private String accessKeyId;
    /**
     * 用来验证用户的密钥
     */
    private String accessKeySecret;
}
