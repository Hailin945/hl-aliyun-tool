package com.chinavisionary.tools.aliyun.sms.template.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.chinavisionary.tools.aliyun.sms.common.config.ClientFactory;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunActionConsts.Template;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunRegionEnum;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunServiceUrlConsts;
import com.chinavisionary.tools.aliyun.sms.common.constants.AliyunSmsQueryParameterConsts;
import com.chinavisionary.tools.aliyun.sms.common.dto.Result;
import com.chinavisionary.tools.aliyun.sms.template.constants.SmsTemplateStatusEnum;
import com.chinavisionary.tools.aliyun.sms.template.constants.SmsTemplateTypeEnum;
import com.chinavisionary.tools.aliyun.sms.template.dto.SmsTemplateDTO;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateCreateParam;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateDeleteParam;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateGetParam;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateUpdateParam;
import com.chinavisionary.tools.aliyun.sms.template.service.SmsTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Hailin
 * @date 2019/12/9
 */
@Service
public class SmsTemplateServiceImpl implements SmsTemplateService {

    private static final int success = 200;

    @Resource
    private ClientFactory clientFactory;

    @Override
    public Result<SmsTemplateDTO> create(SmsTemplateCreateParam param) {
        Result<SmsTemplateDTO> result = new Result<>();
        try {
            IAcsClient client = clientFactory.getClient(
                    AliyunRegionEnum.CN_HANGZHOU, param.getAccessKeyId(), param.getAccessKeySecret());

            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain(AliyunServiceUrlConsts.SMS_SEND);
            request.setVersion("2017-05-25");
            request.setAction(Template.ADD_SMS_TEMPLATE);
            request.putQueryParameter(AliyunSmsQueryParameterConsts.REGION_ID, AliyunRegionEnum.CN_HANGZHOU.getCode());
            request.putQueryParameter(
                    AliyunSmsQueryParameterConsts.TEMPLATE_TYPE, String.valueOf(param.getTemplateTypeEnum().getCode()));
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_NAME, param.getTemplateName());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_CONTENT, param.getTemplateContent());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.REMARK, param.getRemark());
            CommonResponse commonResponse = client.getCommonResponse(request);
            if (commonResponse.getHttpStatus() == success) {
                String data = commonResponse.getData();
                JSONObject jsonObject = JSONObject.parseObject(data);
                result.setCode(jsonObject.getString("Code"));
                if (Objects.equals("OK", jsonObject.getString("Code"))) {
                    result.setSuccess(true);
                } else {
                    result.setSuccess(false);
                }
                result.setMsg(jsonObject.getString("Message"));
                result.setRequestId(jsonObject.getString("RequestId"));
                SmsTemplateDTO smsTemplateDTO = new SmsTemplateDTO();
                smsTemplateDTO.setTemplateCode(jsonObject.getString("TemplateCode"));
                result.setData(smsTemplateDTO);
            }
            return result;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CommonResponse delete(SmsTemplateDeleteParam param) {
        try {
            IAcsClient client = clientFactory.getClient(
                    AliyunRegionEnum.CN_HANGZHOU, param.getAccessKeyId(), param.getAccessKeySecret());

            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain(AliyunServiceUrlConsts.SMS_SEND);
            request.setVersion("2017-05-25");
            request.setAction(Template.DELETE_SMS_TEMPLATE);
            request.putQueryParameter(AliyunSmsQueryParameterConsts.REGION_ID, AliyunRegionEnum.CN_HANGZHOU.getCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_CODE, param.getTemplateCode());
            return client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new CommonResponse();
    }

    @Override
    public CommonResponse update(SmsTemplateUpdateParam param) {
        try {
            IAcsClient client = clientFactory.getClient(
                    AliyunRegionEnum.CN_HANGZHOU, param.getAccessKeyId(), param.getAccessKeySecret());

            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain(AliyunServiceUrlConsts.SMS_SEND);
            request.setVersion("2017-05-25");
            request.setAction(Template.MODIFY_SMS_TEMPLATE);
            request.putQueryParameter(AliyunSmsQueryParameterConsts.REGION_ID, AliyunRegionEnum.CN_HANGZHOU.getCode());
            request.putQueryParameter(
                    AliyunSmsQueryParameterConsts.TEMPLATE_TYPE, String.valueOf(param.getTemplateTypeEnum().getCode()));
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_NAME, param.getTemplateName());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_CODE, param.getTemplateCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_CONTENT, param.getTemplateContent());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.REMARK, param.getRemark());
            return client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new CommonResponse();
    }

    @Override
    public Result<SmsTemplateDTO> get(SmsTemplateGetParam param) {
        Result<SmsTemplateDTO> result = new Result<>();
        try {
            IAcsClient client = clientFactory.getClient(
                    AliyunRegionEnum.CN_HANGZHOU, param.getAccessKeyId(), param.getAccessKeySecret());

            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain(AliyunServiceUrlConsts.SMS_SEND);
            request.setVersion("2017-05-25");
            request.setAction(Template.QUERY_SMS_TEMPLATE);
            request.putQueryParameter(AliyunSmsQueryParameterConsts.REGION_ID, AliyunRegionEnum.CN_HANGZHOU.getCode());
            request.putQueryParameter(AliyunSmsQueryParameterConsts.TEMPLATE_CODE, param.getTemplateCode());
            CommonResponse commonResponse = client.getCommonResponse(request);
            if (commonResponse.getHttpStatus() == success) {
                String data = commonResponse.getData();
                JSONObject jsonObject = JSONObject.parseObject(data);
                result.setCode(jsonObject.getString("Code"));
                if (Objects.equals("OK", jsonObject.getString("Code"))) {
                    result.setSuccess(true);
                } else {
                    result.setSuccess(false);
                }
                result.setMsg(jsonObject.getString("Message"));
                result.setRequestId(jsonObject.getString("RequestId"));
                SmsTemplateDTO smsTemplateDTO = new SmsTemplateDTO();
                smsTemplateDTO.setTemplateCode(jsonObject.getString("TemplateCode"));
                smsTemplateDTO.setCreateDate(jsonObject.getString("CreateDate"));
                smsTemplateDTO.setReason(jsonObject.getString("Reason"));
                smsTemplateDTO.setTemplateContent(jsonObject.getString("TemplateContent"));
                smsTemplateDTO.setTemplateName(jsonObject.getString("TemplateName"));
                smsTemplateDTO.setTemplateStatusEnum(
                        SmsTemplateStatusEnum.getByCode(jsonObject.getInteger("TemplateStatus")));
                smsTemplateDTO.setTemplateTypeEnum(
                        SmsTemplateTypeEnum.getByCode(jsonObject.getInteger("TemplateType")));
                result.setData(smsTemplateDTO);
            }
            return result;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<SmsTemplateDTO> get(String templateCode) {
        SmsTemplateGetParam param = new SmsTemplateGetParam();
        param.setTemplateCode(templateCode);
        return this.get(param);
    }
}
