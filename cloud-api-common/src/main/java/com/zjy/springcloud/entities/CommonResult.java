package com.zjy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhujunyang
 * created on 2021/8/25 10:37
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{

    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
