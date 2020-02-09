package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 异步检测图片请求参数对象
 *
 * @author Hailin
 * @date 2019/12/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageAsyncScanParam extends ImageScanParam {

    /**
     * 异步检测结果回调通知您的URL，支持HTTP/HTTPS。该字段为空时，您必须定时检索检测结果。
     * <p>
     * 如果您在请求参数中指定了回调通知参数callback，被回调callback值，即一个http(s)协议接口的URL，则需要支持POST方法，
     * 传输数据编码采用utf-8，并且支持两个表单参数checksum和content。
     * 系统将按以下描述的生成规则和格式设置checksum和content的值，调用您的callback接口返回检测内容。
     * <p>
     * 您服务端接收到我们推送的结果后，返回的HTTP状态码为200时，表示推送成功，其他的HTTP状态码均视为您接收失败，我们将最多重复推送16次。
     */
    private String callback;
    /**
     * 随机字符串，该值用于回调通知请求中的签名。当使用callback时，该字段必须提供。
     */
    private String seed;
}
