package com.chinavisionary.tools.aliyun.sms.sms.service;

import com.aliyuncs.CommonResponse;
import com.chinavisionary.tools.aliyun.sms.sms.param.SmsSendBatchSmsParam;
import com.chinavisionary.tools.aliyun.sms.sms.param.SmsSendSmsParam;

/**
 * 阿里云短信业务
 *
 * @author Hailin
 * @date 2019/12/9
 */
public interface SmsService {

    /**
     * 发送短信
     *
     * @param param 发送短信请求参数
     * @return 返回结果
     */
    CommonResponse sendSms(SmsSendSmsParam param);

    /**
     * 批量发送短信
     *
     * @param param 发送短信请求参数
     * @return 返回结果
     */
    CommonResponse sendBatchSms(SmsSendBatchSmsParam param);
}
