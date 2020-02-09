package com.chinavisionary.tools.aliyun.green.image.dto;

import lombok.Data;

/**
 * 图片标签识别数据传输对象
 *
 * @author Hailin
 * @date 2019/12/17
 */
@Data
public class ImageScanDTO {

    /**
     * 错误码，和HTTP的status code一致。
     */
    private Integer code;
    /**
     * 错误描述信息
     */
    private String msg;
    /**
     * 对应请求中的dataId。
     */
    private String dataId;
    /**
     * 该检测任务的ID。
     */
    private String taskId;
    /**
     * 对应请求中的URL
     */
    private String url;


}
