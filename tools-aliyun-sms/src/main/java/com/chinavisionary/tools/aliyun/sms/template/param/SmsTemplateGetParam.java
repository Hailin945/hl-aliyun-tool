package com.chinavisionary.tools.aliyun.sms.template.param;

import com.chinavisionary.tools.aliyun.sms.common.param.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hailin
 * @date 2019/12/9
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SmsTemplateGetParam extends BaseParam {
    /**
     * 短信模板CODE。您可以在控制台模板管理页面或API接口create的返回参数中获取短信模板CODE。（注：必填项）
     */
    private String templateCode;
}
