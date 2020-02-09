package com.chinavisionary.tools.aliyun.sms.template.param;

import com.chinavisionary.tools.aliyun.sms.common.param.BaseParam;
import com.chinavisionary.tools.aliyun.sms.template.constants.SmsTemplateTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hailin
 * @date 2019/12/9
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SmsTemplateUpdateParam extends BaseParam {
    /**
     * 短信类型。（注：必填项）
     */
    private SmsTemplateTypeEnum templateTypeEnum;
    /**
     * 短信模板CODE。您可以在控制台模板管理页面或API接口create的返回参数中获取短信模板CODE。（注：必填项）
     */
    private String templateCode;
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
     * 短信模板申请说明。请在申请说明中描述您的业务使用场景，长度为1~100个字符。（注：必填项）
     */
    private String remark;
    /**
     * 阿里云API的名称。取值：AddSmsTemplate。
     */
    private String action;
    /**
     * 主账号AccessKey的ID。
     */
    private String accessKeyIdMaster;
}
