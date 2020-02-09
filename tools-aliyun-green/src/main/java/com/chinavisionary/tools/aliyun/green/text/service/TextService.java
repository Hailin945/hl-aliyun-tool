package com.chinavisionary.tools.aliyun.green.text.service;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.text.dto.TextScanDTO;
import com.chinavisionary.tools.aliyun.green.text.param.TextScanParam;

import java.util.List;

/**
 * 文本垃圾内容检测
 *
 * @author Hailin
 * @date 2019/12/19
 */
public interface TextService {

    /**
     * 文本垃圾内容检测
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<TextScanDTO>> textScan(TextScanParam param);
}
