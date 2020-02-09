package com.chinavisionary.tools.aliyun.green.image.dto;

import com.chinavisionary.tools.aliyun.green.common.dto.DataResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Hailin
 * @date 2019/12/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SimilarityLibraryListDTO extends DataResult<List<SimilarityLibraryDTO>> {

    /**
     * 图库总数量。
     */
    private Integer totalCount;
    /**
     * 每页大小，取值范围：(0,50]。
     */
    private Integer pageSize;
    /**
     * 当前页码，取值范围：(0,50]。
     */
    private Integer currentPage;

    public SimilarityLibraryListDTO() {
    }

    public SimilarityLibraryListDTO(Boolean success, String msg, String code) {
        super(success, msg, code);
    }

    public SimilarityLibraryListDTO(Boolean success, String msg) {
        super(success, msg);
    }
}
