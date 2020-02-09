package com.chinavisionary.tools.aliyun.green.common.constants;

/**
 * 阿里云API的名称
 *
 * @author Hailin
 * @date 2019/12/9
 */
public class AliyunActionConsts {

    public static class Sms {
        public static final String SEND_SMS = "SendSms";

        public static final String SEND_BATCH_SMS = "SendBatchSms";
    }

    public static class Template {
        public static final String ADD_SMS_TEMPLATE = "AddSmsTemplate";
        public static final String DELETE_SMS_TEMPLATE = "DeleteSmsTemplate";
        public static final String MODIFY_SMS_TEMPLATE = "ModifySmsTemplate";
        public static final String QUERY_SMS_TEMPLATE = "QuerySmsTemplate";
    }

    private AliyunActionConsts() {
    }
}
