package com.chinavisionary.tools.aliyun.green.image.param;

import com.chinavisionary.tools.aliyun.green.common.constants.GreenSceneEnum;
import com.chinavisionary.tools.aliyun.green.common.param.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 检测图片请求参数对象
 *
 * @author Hailin
 * @date 2019/12/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageScanParam extends BaseParam {

    /**
     * 该字段用于标识业务场景。针对不同的业务场景，您可以配置不同的内容审核策略，以满足不同场景下不同的审核标准或算法策略的需求。
     * 您可以通过云盾内容安全控制台创建业务场景（bizType），或者通过工单联系我们帮助您创建业务场景。
     */
    private String bizType;
    /**
     * 待检测图像的URL（注：最多支持10个元素，即对10张图片进行检测）
     */
    private List<ImageParam> tasks;
    /**
     * 指定图片检测的应用场景
     * @see GreenSceneEnum
     */
    private List<String> scenes;
}
