package com.chinavisionary.tools.aliyun.green.file.dto;

import lombok.Data;

/**
 * @author Hailin
 * @date 2019/12/21
 */
@Data
public class FileTaskDTO {

    /**
     * 数据Id。需要保证在一次请求中Id不重复。
     */
    private String dataId;
    /**
     * 文件下载的URL。
     */
    private String url;
}
