package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * 图片样本
 *
 * @author Hailin
 * @date 2019/12/18
 */
@Data
public class ImageParam {

    /**
     * 该样本在您的业务系统里的唯一ID。例如，您可以指定该样本ID为"1"、"s-001"等。
     */
    private String dataId;
    /**
     * 样本图片的URL。
     */
    private String url;
    /**
     * 为该样本图片设置标签。每个元素是字符串，最多允许设置3个标签值。例如，您可以为样本图片添加["涉黄", "渉政"]标签。
     */
    private List<String> tags;
    /**
     * 在图库中创建图片样本的时间戳。
     */
    private Long createTime;
    /**
     * 额外调用参数。
     */
    private ImageExtrasParam extras;
    /**
     * 指定要检索的相似图库的名称。如果不指定该参数，即从默认图库中检索。默认图库的名称为default。
     */
    private List<String> similarityLibraries;

    public static ImageParam init() {
        ImageParam imageParam = new ImageParam();
        imageParam.setDataId(UUID.randomUUID().toString());
        imageParam.setCreateTime(System.currentTimeMillis());
        return imageParam;
    }
}
