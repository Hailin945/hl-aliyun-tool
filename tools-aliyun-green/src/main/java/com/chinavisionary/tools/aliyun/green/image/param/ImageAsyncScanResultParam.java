package com.chinavisionary.tools.aliyun.green.image.param;

import com.chinavisionary.tools.aliyun.green.common.param.BaseParam;
import lombok.Data;

import java.util.List;

/**
 * 获取图片异步检测结果请求参数
 *
 * @author Hailin
 * @date 2019/12/17
 */
@Data
public class ImageAsyncScanResultParam extends BaseParam {

    /**
     * 要查询的taskId列表。最大长度不超过1,000。
     */
    private List<String> taskIdList;
}
