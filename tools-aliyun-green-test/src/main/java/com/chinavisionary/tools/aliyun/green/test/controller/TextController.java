package com.chinavisionary.tools.aliyun.green.test.controller;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.text.dto.TextScanDTO;
import com.chinavisionary.tools.aliyun.green.text.param.TextScanParam;
import com.chinavisionary.tools.aliyun.green.text.service.TextService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/19
 */
@RestController
@RequestMapping("/v1/text")
public class TextController {

    @Resource
    private TextService textService;

    @PostMapping("/scan")
    public DataResult<List<TextScanDTO>> textScan(@RequestBody TextScanParam param) {
        return textService.textScan(param);
    }
}
