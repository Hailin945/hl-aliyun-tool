package com.chinavisionary.tools.aliyun.sms.test.controller;

import com.aliyuncs.CommonResponse;
import com.chinavisionary.tools.aliyun.sms.sms.param.SmsSendSmsParam;
import com.chinavisionary.tools.aliyun.sms.sms.service.SmsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hailin
 * @date 2019/12/9
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Resource
    private SmsService smsService;

    @GetMapping("/send")
    public CommonResponse sendSms(SmsSendSmsParam param) {
        return smsService.sendSms(param);
    }
}
