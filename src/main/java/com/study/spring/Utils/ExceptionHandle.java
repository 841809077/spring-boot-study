package com.study.spring.Utils;

import com.study.spring.Enum.ExceptionEnum;
import com.study.spring.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/11/2 0002
 */
//@ControllerAdvice
@Component
@Slf4j
public class ExceptionHandle {

    //    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
    public Result exceptionGet(Throwable t) {
        log.error("异常信息：", t);
        if (t instanceof InvalidDataAccessResourceUsageException) {
            return ResultUtil.error(ExceptionEnum.INVALID_EXCEPTION);
        } else if (t instanceof NullPointerException) {
            return ResultUtil.error(ExceptionEnum.NULL_EXCEPTION);
        }
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }

}
