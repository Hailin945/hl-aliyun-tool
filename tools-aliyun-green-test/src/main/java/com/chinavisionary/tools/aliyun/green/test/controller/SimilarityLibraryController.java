package com.chinavisionary.tools.aliyun.green.test.controller;

import com.chinavisionary.tools.aliyun.green.common.dto.Result;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityLibraryDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.SimilarityLibraryListDTO;
import com.chinavisionary.tools.aliyun.green.image.service.SimilarityLibraryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@RestController
@RequestMapping("/v1/image/similarity/library")
public class SimilarityLibraryController {

    @Resource
    private SimilarityLibraryService similarityLibraryService;

    @PostMapping("/{name}")
    public DataResult<SimilarityLibraryDTO> create(@PathVariable String name) {
        return similarityLibraryService.create(name);
    }

    @DeleteMapping("/{name}")
    public Result delete(@PathVariable String name) {
        return similarityLibraryService.delete(name);
    }

    @GetMapping("/{name}")
    public DataResult<SimilarityLibraryDTO> get(@PathVariable String name) {
        return similarityLibraryService.get(name);
    }

    @GetMapping
    public SimilarityLibraryListDTO list(Integer pageSize, Integer currentPage) {
        return similarityLibraryService.list(pageSize, currentPage);
    }
}
