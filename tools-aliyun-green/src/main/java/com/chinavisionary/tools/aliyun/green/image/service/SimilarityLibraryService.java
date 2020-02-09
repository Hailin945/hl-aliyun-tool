package com.chinavisionary.tools.aliyun.green.image.service;

import com.chinavisionary.tools.aliyun.green.common.dto.Result;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityLibraryDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityLibraryListDTO;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityLibraryCreateParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityLibraryDeleteParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityLibraryGetParam;
import com.chinavisionary.tools.aliyun.green.image.param.SimilarityLibraryListParam;

/**
 * 相似图图库管理
 *
 * @author Hailin
 * @date 2019/12/18
 */
public interface SimilarityLibraryService {

    /**
     * 创建图库
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<SimilarityLibraryDTO> create(SimilarityLibraryCreateParam param);

    /**
     * 创建图库
     *
     * @param name 图库名称
     * @return 返回结果
     */
    DataResult<SimilarityLibraryDTO> create(String name);

    /**
     * 删除图库
     *
     * @param param 请求参数
     * @return 返回结果
     */
    Result delete(SimilarityLibraryDeleteParam param);

    /**
     * 删除图库
     *
     * @param name 图库名称
     * @return 返回结果
     */
    Result delete(String name);

    /**
     * 查询指定图库信息
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<SimilarityLibraryDTO> get(SimilarityLibraryGetParam param);

    /**
     * 查询指定图库信息
     *
     * @param name 图库名称
     * @return 返回结果
     */
    DataResult<SimilarityLibraryDTO> get(String name);

    /**
     * 查询图库列表
     *
     * @param param 请求参数
     * @return 返回结果
     */
    SimilarityLibraryListDTO list(SimilarityLibraryListParam param);

    /**
     * 查询图库列表
     *
     * @param pageSize    每页大小，取值范围：(0,50]。
     * @param currentPage 当前页码，取值范围：(0,50]。
     * @return 返回结果
     */
    SimilarityLibraryListDTO list(Integer pageSize, Integer currentPage);
}
