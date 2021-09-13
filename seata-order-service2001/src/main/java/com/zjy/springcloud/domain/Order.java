package com.zjy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhujunyang
 * created on 2021/9/10 17:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;

    private Long userId;

    private Long produceId;

    private Integer count;

    private BigDecimal money;


    private Integer status; //0 创建中；  1  已完结
}
