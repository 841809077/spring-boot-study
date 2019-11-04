package com.study.spring.Enum;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/11/2 0002
 */
@AllArgsConstructor
public enum  ExceptionEnum {

    UNKNOW_ERROR(-1,"未知错误123"),

    USER_NOT_FIND(-101,"用户不存在");

    public Integer code;

    public String msg;

}
