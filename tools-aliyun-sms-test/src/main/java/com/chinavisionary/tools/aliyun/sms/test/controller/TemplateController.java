package com.chinavisionary.tools.aliyun.sms.test.controller;

import com.chinavisionary.tools.aliyun.sms.common.dto.Result;
import com.chinavisionary.tools.aliyun.sms.template.constants.SmsTemplateTypeEnum;
import com.chinavisionary.tools.aliyun.sms.template.dto.SmsTemplateDTO;
import com.chinavisionary.tools.aliyun.sms.template.param.SmsTemplateCreateParam;
import com.chinavisionary.tools.aliyun.sms.template.service.SmsTemplateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Hailin
 * @date 2019/12/9
 */
@RestController
@RequestMapping("/sms/template")
public class TemplateController {

    @Resource
    private SmsTemplateService smsTemplateService;

    @PostMapping("/create")
    public Result<SmsTemplateDTO> create(@RequestBody SmsTemplateCreateParam param) {
        param.setTemplateTypeEnum(SmsTemplateTypeEnum.VERIFICATION_CODE);
        return smsTemplateService.create(param);
    }

    @GetMapping("/{templateCode}")
    public Result<SmsTemplateDTO> get(@PathVariable String templateCode) {
        return smsTemplateService.get(templateCode);
    }
}
