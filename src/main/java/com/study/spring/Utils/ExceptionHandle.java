package com.study.spring.Utils;

import com.study.spring.Enum.ExceptionEnum;
import com.study.spring.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
//        if(t instanceof Exception){
//            DescribeException MyException = (DescribeException) e;
//            return ResultUtil.error(MyException.getCode(),MyException.getMessage());
//        }

//        log.error("获取详细错误日志: ", t);
//        return ResultUtil.error(-1, t.getMessage());
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }

}
