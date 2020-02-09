package com.chinavisionary.tools.aliyun.green.image.service;

import com.chinavisionary.tools.aliyun.green.common.constants.GreenSceneEnum;
import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageAsyncScanDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageAsyncScanResultDTO;
import com.chinavisionary.tools.aliyun.green.image.dto.ImageSyncScanDTO;
import com.chinavisionary.tools.aliyun.green.image.param.ImageAsyncScanParam;
import com.chinavisionary.tools.aliyun.green.image.param.ImageAsyncScanResultParam;
import com.chinavisionary.tools.aliyun.green.image.param.ImageSyncScanParam;
import com.chinavisionary.tools.aliyun.green.image.param.ImageSyncScanSimilarityParam;

import java.util.List;

/**
 * 图片检测识别
 *
 * @author Hailin
 * @date 2019/12/16
 */
public interface ImageScanService {

    /**
     * 同步检测
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<ImageSyncScanDTO>> imageSyncScan(ImageSyncScanParam param);

    /**
     * 同步检测
     *
     * @param imageUrlList  待检测图像的URL（注：最多支持10个元素，即对10张图片进行检测）
     * @param sceneEnumList 指定图片检测的应用场景列表
     * @return 返回结果
     */
    DataResult<List<ImageSyncScanDTO>> imageSyncScan(List<String> imageUrlList, List<GreenSceneEnum> sceneEnumList);

    /**
     * 同步检测-相似图检索
     *
     * @param paramList 请求参数
     * @return 返回结果
     */
    DataResult<List<ImageSyncScanDTO>> imageSyncScanSimilarity(List<ImageSyncScanSimilarityParam> paramList);

    /**
     * 异步检测
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<ImageAsyncScanDTO>> imageAsyncScan(ImageAsyncScanParam param);

    /**
     * 获取异步检测结果
     *
     * @param param 请求参数
     * @return 返回结果
     */
    DataResult<List<ImageAsyncScanResultDTO>> imageAsyncScanResult(ImageAsyncScanResultParam param);

    /**
     * 获取异步检测结果
     *
     * @param taskIdList 要查询的taskId列表。最大长度不超过1,000。
     * @return 返回结果
     */
    DataResult<List<ImageAsyncScanResultDTO>> imageAsyncScanResult(List<String> taskIdList);
}
