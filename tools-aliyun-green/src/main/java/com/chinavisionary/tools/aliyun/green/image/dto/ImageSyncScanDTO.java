package com.chinavisionary.tools.aliyun.green.image.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * @author Hailin
 * @date 2019/12/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageSyncScanDTO extends ImageScanDTO {

    /**
     * 额外调用参数（说明 该参数可能会被调整，目前请勿依赖该参数的返回值。）
     */
    private Map extras;
    /**
     * 返回结果。调用成功时（code=200），返回结果中包含一个或多个元素。
     */
    private List<ImageScanResultDTO> results;
}
