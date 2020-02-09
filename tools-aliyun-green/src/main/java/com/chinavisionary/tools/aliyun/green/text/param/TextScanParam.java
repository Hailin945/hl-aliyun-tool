package com.chinavisionary.tools.aliyun.green.text.param;

import com.chinavisionary.tools.aliyun.green.common.constants.GreenSceneEnum;
import com.chinavisionary.tools.aliyun.green.common.param.BaseParam;
import lombok.Data;

import java.util.List;

/**
 * 文本垃圾内容检测请求参数对象
 *
 * @author Hailin
 * @date 2019/12/19
 */
@Data
public class TextScanParam extends BaseParam {

    /**
     * 该字段用于标识业务场景。
     * 针对不同的业务场景，您可以配置不同的内容审核策略，以满足不同场景下不同的审核标准或算法策略的需求。
     * 您可以通过云盾内容安全控制台创建业务场景（bizType），或者通过工单联系我们帮助您创建业务场景。
     */
    private String bizType;
    /**
     * 文本检测任务列表，包含一个或多个元素。
     * 每个元素是个结构体，最多可添加100个元素，即最多对100段文本进行检测。每个元素的具体结构描述见task。
     */
    private List<TextParam> tasks;
    /**
     * 指定检测场景
     * @see GreenSceneEnum
     */
    private List<String> scenes;
}
