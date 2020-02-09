package com.chinavisionary.tools.aliyun.green.file.param;

import com.chinavisionary.tools.aliyun.green.file.dto.FileTaskDTO;
import lombok.Data;

import java.util.List;

/**
 * 文件异步检测任务请求参数对象
 *
 * @author Hailin
 * @date 2019/12/23
 */
@Data
public class FileAsyncScanParam {

    /**
     * 该字段用于标识业务场景。
     * 针对不同的业务场景，您可以配置不同的内容审核策略，以满足不同场景下不同的审核标准或算法策略的需求。
     * 您可以通过云盾内容安全控制台创建业务场景（bizType），或者通过工单联系我们帮助您创建业务场景。
     */
    private String bizType;
    /**
     * 检测内容包含文本时，指定检测场景
     *
     * @see com.chinavisionary.tools.aliyun.green.common.constants.GreenFileSceneEnum
     */
    private List<String> textScenes;
    /**
     * 检测内容包含图片时，指定检测场景
     *
     * @see com.chinavisionary.tools.aliyun.green.common.constants.GreenFileSceneEnum
     */
    private List<String> imageScenes;
    /**
     * 待检测文件任务
     */
    private List<FileTaskDTO> tasks;
}
