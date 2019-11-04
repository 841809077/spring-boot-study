package com.study.spring.entity;

import lombok.Data;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/11/2 0002
 */
@Data
public class Result<T> {

    // code 状态值：0 代表成功，其他数值代表失败
    private Integer code;

    // msg 信息，若code为0时，为success
    private String msg;

    // data 返回结果集，使用泛型兼容不同的类型
    private T data;

}
