package com.chinavisionary.tools.aliyun.green.image.param;

import lombok.Data;

import java.util.List;

/**
 * 相似图检索请求参数对象
 *
 * @author Hailin
 * @date 2019/12/19
 */
@Data
public class ImageSyncScanSimilarityParam {

    /**
     * 该样本在您的业务系统里的唯一ID。例如，您可以指定该样本ID为"1"、"s-001"等。
     */
    private String dataId;
    /**
     * 样本图片的URL。
     */
    private String url;
    /**
     * 指定要检索的相似图库的名称。如果不指定该参数，即从默认图库中检索。默认图库的名称为default。
     */
    private List<String> similarityLibraries;
}
