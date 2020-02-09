package com.chinavisionary.tools.aliyun.sms.sms.param;

import com.chinavisionary.tools.aliyun.sms.common.param.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 阿里云短信服务，发送短信请求参数
 *
 * @author Hailin
 * @date 2019/12/9
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SmsSendSmsParam extends BaseParam {

    /**
     * 接收短信的手机号码。（注：必填项）
     * <p>
     * 格式：
     * <p>
     * 国内短信：11位手机号码，例如15951955195。
     * 国际/港澳台消息：国际区号+号码，例如85200000000。
     * 支持对多个手机号码发送短信，手机号码之间以英文逗号（,）分隔。上限为1000个手机号码。批量调用相对于单条调用及时性稍有延迟。
     */
    @NotNull(message = "手机号不可为空！")
    private String phoneNumbers;
    /**
     * 短信签名名称。请在控制台签名管理页面签名名称一列查看。（注：必填项）
     */
    @NotNull(message = "短信签名名称不可为空！")
    private String signName;
    /**
     * 短信模板ID。请在控制台模板管理页面模板CODE一列查看。（注：必填项）
     */
    @NotNull(message = "短信模板ID不可为空！")
    private String templateCode;
    /**
     * 主账号AccessKey的ID。
     */
    private String accessKeyIdMaster;
    /**
     * 系统规定参数。取值：SendSms。
     */
    private String action;
    /**
     * 外部流水扩展字段。
     */
    private String outId;
    /**
     * 上行短信扩展码，无特殊需要此字段的用户请忽略此字段。
     */
    private String smsUpExtendCode;
    /**
     * 短信模板变量对应的实际值，JSON格式。
     */
    private Map<String, String> templateParam;
}
