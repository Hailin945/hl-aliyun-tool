package com.chinavisionary.tools.aliyun.sms.template.service;

import com.aliyuncs.CommonResponse;
import com.chinavisionary.tools.aliyun.sms.common.dto.Result;
import com.chinavisionary.tools.aliyun.sms.template.dto.SmsTemplateDTO;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateDeleteParam;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateCreateParam;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateGetParam;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateUpdateParam;

/**
 * @author Hailin
 * @date 2019/12/9
 */
public interface SmsTemplateService {

    /**
     * 申请短信模板
     * <p>
     * 模板内容需要符合文本短信模板规范或国际/港澳台短信模板规范。
     *
     * @param param 申请短信模板请求参数
     * @return 返回结果
     */
    Result<SmsTemplateDTO> create(SmsTemplateCreateParam param);

    /**
     * 删除短信模板
     * <p>
     * 不支持删除正在审核中的模板。
     * 删除短信模板后不可恢复，请谨慎操作。
     *
     * @param param 删除短信模板请求参数
     * @return 返回结果
     */
    CommonResponse delete(SmsTemplateDeleteParam param);

    /**
     * 修改未通过审核的短信模板
     * <p>
     * 申请短信模板后，如果模板未通过审核，可以通过接口update修改短信模板，并重新申请，提交审核。
     *
     * @param param 修改未通过审核的短信模板请求参数
     * @return 返回结果
     */
    CommonResponse update(SmsTemplateUpdateParam param);

    /**
     * 查询短信模板的审核状态
     *
     * @param param 查询短信模板的审核状态请求参数
     * @return 返回结果
     */
    Result<SmsTemplateDTO> get(SmsTemplateGetParam param);

    /**
     * 查询短信模板的审核状态
     *
     * @param templateCode 短信模板CODE。您可以在控制台模板管理页面或API接口AddSmsTemplate的返回参数中获取短信模板CODE。
     * @return 返回结果
     */
    Result<SmsTemplateDTO> get(String templateCode);
}
