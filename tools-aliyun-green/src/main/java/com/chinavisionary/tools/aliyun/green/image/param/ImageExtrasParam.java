package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;

/**
 * 图片检测扩展参数
 *
 * @author Hailin
 * @date 2019/12/19
 */
@Data
public class ImageExtrasParam {

    /**
     * 传入待比较图片中的第二张图片。格式为{"faceUrl":"http://xxx.jpg"}。其中，faceUrl为第二张图片的URL。
     */
    private String faceUrl;
}
