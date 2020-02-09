package com.chinavisionary.tools.aliyun.green.image.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * 检测对象
 *
 * @author Hailin
 * @date 2019/12/17
 */
@Data
public class ImageScanTaskDTO {

    /**
     * 数据Id。需要保证在一次请求中所有的Id不重复。
     */
    private String dataId;
    /**
     * 待检测图像的URL。
     */
    private String url;
    /**
     * 创建日期
     */
    private Date time;

    public ImageScanTaskDTO() {
        this.dataId = UUID.randomUUID().toString();
        this.time = new Date();
    }

    public ImageScanTaskDTO(String url) {
        this.url = url;
        this.dataId = UUID.randomUUID().toString();
        this.time = new Date();
    }
}
