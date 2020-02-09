package com.chinavisionary.tools.aliyun.green.text.param;

import lombok.Data;

import java.util.UUID;

/**
 * 文本请求参数对象
 *
 * @author Hailin
 * @date 2019/12/19
 */
@Data
public class TextParam {

    /**
     * 数据Id。需要保证在一次请求中所有的Id不重复。
     */
    private String dataId;
    /**
     * 待检测文本，最长10000个字符。
     */
    private String content;

    public static TextParam init() {
        TextParam textParam = new TextParam();
        textParam.setDataId(UUID.randomUUID().toString());
        return textParam;
    }
}
