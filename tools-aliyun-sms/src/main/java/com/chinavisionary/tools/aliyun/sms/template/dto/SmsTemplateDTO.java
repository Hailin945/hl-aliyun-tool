package com.chinavisionary.tools.aliyun.sms.template.dto;

import com.chinavisionary.tools.aliyun.sms.template.constants.SmsTemplateStatusEnum;
import com.chinavisionary.tools.aliyun.sms.template.constants.SmsTemplateTypeEnum;
import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/10
 */
@Data
public class SmsTemplateDTO {

    /**
     * 短信模板CODE。您可以在控制台模板管理页面或API接口AddSmsTemplate的返回参数中获取短信模板CODE。（注：必填项）
     */
    private String templateCode;

    /**
     * 短信模板的创建日期和时间。
     */
    private String createDate;
    /**
     * 审核备注。
     * <p>
     * 如果审核状态为审核通过或审核中，参数Reason显示为“无审核备注”。
     * 如果审核状态为审核未通过，参数Reason显示审核的具体原因。
     */
    private String reason;
    /**
     * 短信类型。（注：必填项）
     */
    private SmsTemplateTypeEnum templateTypeEnum;
    /**
     * 模板名称，长度为1~30个字符。（注：必填项）
     */
    private String templateName;
    /**
     * 模板内容，长度为1~500个字符。
     * <p>
     * 模板内容需要符合文本短信模板规范或国际/港澳台短信模板规范。（注：必填项）
     */
    private String templateContent;
    /**
     * 模板审核状态。其中：
     * <p>
     * 0：审核中。
     * 1：审核通过。
     * 2：审核失败，请在返回参数Reason中查看审核失败原因。
     */
    private SmsTemplateStatusEnum templateStatusEnum;
}
