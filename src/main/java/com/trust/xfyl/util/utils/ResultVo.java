package com.trust.xfyl.util.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description: 封装返回值
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/


@Data
@AllArgsConstructor
public class ResultVo<T> {
    private String msg;
    private int code;
    private T data;
}
