package com.henu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author JinK
 * @date 2020/6/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    /**
     * 重载构造方法
     * @param code
     * @param msg
     */
    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
