package com.chinavisionary.tools.aliyun.sms.sms.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.chinavisionary.tools.aliyun.sms.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunSmsQueryParameterConsts;
import com.chinavisionary.tools.aliyun.sms.sms.param.SmsSendBatchSmsParam;
import com.chinavisionary.tools.aliyun.sms.sms.param.SmsSendSmsParam;
import com.chinavisionary.tools.aliyun.sms.sms.service.SmsService;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunActionConsts.Sms;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunRegionEnum;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunServiceUrlConsts;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hailin
 * @date 2019/12/9
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Resource
    private ClientFactory clientFactory;

    @Override
    public CommonResponse sendSms(SmsSendSmsParam param) {
        try {
            IAcsClient client = clientFactory.getClient(
                    AliyunRegionEnum.CN_HANGZHOU, param.getAccessKeyId(), param.getAccessKeySecret());

            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain(AliyunServiceUrlConsts.SMS_SEND);
            request.setVersion("2017-05-25");
            request.setAction(Sms.SEND_SMS);
            request.putQueryParameter(AliyunSmsQueryParameterConsts.REGION_ID, AliyunRegionEnum.CN_HANGZHOU.getCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.PHONE_NUMBER_JSON, param.getPhoneNumbers());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.SIGN_NAME, param.getSignName());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_CODE, param.getTemplateCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_PARAM, JSON.toJSONString(param.getTemplateParam()));
            request.putQueryParameter(AliyunSmsQueryParameterConsts.SMS_UP_EXTEND_CODE, param.getSmsUpExtendCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.OUT_ID, param.getOutId());
            return client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        CommonResponse commonResponse = new CommonResponse();
        return commonResponse;
    }

    @Override
    public CommonResponse sendBatchSms(SmsSendBatchSmsParam param) {
        try {
            IAcsClient client = clientFactory.getClient(
                    AliyunRegionEnum.CN_HANGZHOU, param.getAccessKeyId(), param.getAccessKeySecret());

            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain(AliyunServiceUrlConsts.SMS_SEND);
            request.setVersion("2017-05-25");
            request.setAction(Sms.SEND_BATCH_SMS);
            request.putQueryParameter(AliyunSmsQueryParameterConsts.REGION_ID, AliyunRegionEnum.CN_HANGZHOU.getCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.PHONE_NUMBER_JSON, param.getPhoneNumbers());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.SIGN_NAME, param.getSignName());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_CODE, param.getTemplateCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_PARAM, JSON.toJSONString(param.getTemplateParam()));
            request.putQueryParameter(AliyunSmsQueryParameterConsts.SMS_UP_EXTEND_CODE, param.getSmsUpExtendCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.OUT_ID, param.getOutId());
            return client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new CommonResponse();
    }
}
