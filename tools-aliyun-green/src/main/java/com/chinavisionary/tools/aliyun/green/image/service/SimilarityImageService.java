package com.chinavisionary.tools.aliyun.green.image.service;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageDTO;
import com.chinavisionary.tools.aliyun.green.image.param.ImageParam;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityImageListDTO;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityImageCreateParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityImageDeleteParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityImageGetParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityImageListParam;

import java.util.List;

/**
 * 相似图图片管理
 *
 * @author Hailin
 * @date 2019/12/18
 */
public interface SimilarityImageService {

    /**
     * 添加样本图片
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<ImageDTO>> create(SimilarityImageCreateParam param);

    /**
     * 删除样本图片
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<ImageParam>> delete(SimilarityImageDeleteParam param);

    /**
     * 查询样本图片详情
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<ImageParam> get(SimilarityImageGetParam param);

    /**
     * 查询样本图片列表
     *
     * @param param 请求参数
     * @return 返回结果
     */
    SimilarityImageListDTO list(SimilarityImageListParam param);
}
