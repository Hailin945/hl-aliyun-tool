package com.chinavisionary.tools.aliyun.green.file.dto;

import com.chinavisionary.tools.aliyun.green.image.dto.ImageScanResultDTO;
import com.chinavisionary.tools.aliyun.green.text.dto.TextScanDTO;
import lombok.Data;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/23
 */
@Data
public class FileAsyncScanResultDTO {

    /**
     * 错误码，和HTTP的status code一致。
     */
    private Integer code;
    /**
     * 错误描述信息。
     */
    private String msg;
    /**
     * 对应的请求中的dataId。
     */
    private String dataId;
    /**
     * 检测任务的ID。
     */
    private String taskId;
    /**
     *传入textScenes时的文本扫描结果
     */
    private List<TextScanDTO> textResults;
    /**
     * 传入imageScenes时的图片扫描结果
     */
    private List<ImageScanResultDTO> imageResults;
    /**
     * 检测的源文件链接
     */
    private String url;
}
