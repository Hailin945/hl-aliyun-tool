package com.chinavisionary.tools.aliyun.green.file.dto;

import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/23
 */
@Data
public class FileAsyncScanDTO {

    private String code;

    private String msg;
    /**
     * 数据Id。需要保证在一次请求中Id不重复。
     */
    private String dataId;
    /**
     * 该检测任务的ID。
     */
    private String taskId;
}
