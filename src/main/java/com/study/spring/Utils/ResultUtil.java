package com.study.spring.Utils;

import com.study.spring.Enum.ExceptionEnum;
import com.study.spring.entity.Result;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/11/2 0002
 */
public class ResultUtil {

    /**
     * @return com.study.spring.entity.Result
     * @description 接口调用成功返回的数据格式
     * @param: object
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * @return com.study.spring.entity.Result
     * @description 接口调用失败返回的数据格式
     * @param: code
     * @param: msg
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     *
     * @param exceptionEnum
     * @return
     */
    public static Result error(ExceptionEnum exceptionEnum) {
        Result result = new Result();
        result.setCode(exceptionEnum.code);
        result.setMsg(exceptionEnum.msg);
        result.setData(null);
        return result;
    }

}
