package com.chinavisionary.tools.aliyun.green.common.param;

import com.chinavisionary.tools.aliyun.green.common.constants.RegionGreenEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 公共参数
 *
 * @author Hailin
 * @date 2019/12/9
 */
@Data
public class BaseParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 访问密钥 ID。AccessKey 用于调用 API。（注：必填项）
     */
    private String accessKeyId;
    /**
     * 访问密钥（注：必填项）
     */
    private String accessKeySecret;
    /**
     * API支持的RegionID，如短信API的值为：cn-hangzhou。
     *
     * @see RegionGreenEnum
     */
    private String regionId;

    /// 暂时未用到，用到时可以放开
    // /**
    //  * 请求签名，即最终生成的签名结果值。（注：必填项）
    //  */
    // private String signature;
    // /**
    //  * API的名称。（注：必填项）
    //  */
    // private String action;
    // /**
    //  * 返回参数的语言类型。取值范围：json |xml。默认值：json。
    //  */
    // private String format;
    // /**
    //  * 签名方式。取值范围：HMAC-SHA1。（注：必填项）
    //  */
    // private String signatureMethod;
    // /**
    //  * 签名唯一随机数。用于防止网络重放攻击，建议您每一次请求都使用不同的随机数。
    //  * JAVA语言建议用：java.util.UUID.randomUUID()生成。（注：必填项）
    //  */
    // private String signatureNonce;
    // /**
    //  * 签名算法版本。取值范围：1.0。（注：必填项）
    //  */
    // private String signatureVersion;
    // /**
    //  * 请求的时间戳。按照ISO8601 标准表示，并需要使用UTC时间，格式为yyyy-MM-ddTHH:mm:ssZ。
    //  * 示例：2018-01-01T12:00:00Z 表示北京时间 2018 年 01 月 01 日 20 点 00 分 00 秒。（注：必填项）
    //  */
    // private String timestamp;
    // /**
    //  * API 的版本号，格式为 YYYY-MM-DD。取值范围：2017-05-25。
    //  */
    // private String version;
}
