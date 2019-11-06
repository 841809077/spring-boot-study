package com.study.spring.Enum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/11/2 0002
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {

    UNKNOW_ERROR(-1, "未知错误"),
    NULL_EXCEPTION(-2, "空指针异常：NullPointerException"),
    INVALID_EXCEPTION(1146, "无效的数据访问资源使用异常：InvalidDataAccessResourceUsageException");

    public Integer code;

    public String msg;

}
