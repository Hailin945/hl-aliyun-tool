package com.chinavisionary.tools.aliyun.green.test.controller;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityImageListDTO;
import com.chinavisionary.tools.aliyun.green.image.param.*;
import com.chinavisionary.tools.aliyun.green.image.service.SimilarityImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@RestController
@RequestMapping("/v1/image/similarity")
public class SimilarityImageController {

    @Resource
    private SimilarityImageService similarityImageService;

    /**
     * 添加样本图片
     *
     * @param param 请求参数
     * @return 返回结果
     */
    @PostMapping
    public DataResult<List<ImageDTO>> create(@RequestBody SimilarityImageCreateParam param) {
        return similarityImageService.create(param);
    }

    /**
     * 删除样本图片
     *
     * @param param 请求参数
     * @return 返回结果
     */
    @DeleteMapping
    public DataResult<List<ImageParam>> delete(@RequestBody SimilarityImageDeleteParam param) {
        return similarityImageService.delete(param);
    }

    /**
     * 查询样本图片详情
     *
     * @param param 请求参数
     * @return 返回结果
     */
    @GetMapping
    public DataResult<ImageParam> get(SimilarityImageGetParam param) {
        return similarityImageService.get(param);
    }

    /**
     * 查询样本图片列表
     *
     * @param param 请求参数
     * @return 返回结果
     */
    @GetMapping("/list")
    public SimilarityImageListDTO list(SimilarityImageListParam param) {
        return similarityImageService.list(param);
    }
}
