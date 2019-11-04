package com.study.spring.aspect;

import com.google.gson.Gson;
import com.study.spring.Utils.ExceptionHandle;
import com.study.spring.Utils.ResultUtil;
import com.study.spring.annotation.HandleResult;
import com.study.spring.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/10/31 0031
 */
@Aspect
@Component
@Slf4j
@Order(100)
public class HandleResultAspect {

    @Autowired
    private ExceptionHandle exceptionHandle;

    //    @Pointcut("@annotation(com.study.spring.annotation.ThrowErr)")
    @Pointcut("execution(* com.study.spring.controller..*.*(..))")
    public void HandleResult() {
    }

    /**
     * @return void
     * @description 打印接口名、类名、方法名及参数名
     * @param: joinPoint
     * @param: t
     */
    @Before(value = "HandleResult()  && @annotation(t)")
    public void doBefore(JoinPoint joinPoint, HandleResult t) throws Exception {
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = joinPoint.getSignature().getName();
        // 参数名
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                sb.append(arg).append(", ");
            }
        }
        log.info("接口 {} 开始被调用, 类名: {}, 方法名: {}, 参数名为: {} .",
                t.desc(), className, methodName, sb.toString());
    }

    /**
     * @return java.lang.Object
     * @description 定义@Around环绕，用于何时执行切点
     * @param: proceedingJoinPoint
     */
    @Around("HandleResult()")
    public Result doAround(ProceedingJoinPoint point) {
        long startTime = System.currentTimeMillis();
        // 执行切点。执行切点后，会去依次调用 @Before -> 接口逻辑代码 -> @After -> @AfterReturning；
        Object result = null;
        try {
            // point.proceed 为方法返回值
            result = point.proceed();
            // 打印出参
            log.info("Response Results: {}", new Gson().toJson(result));
            // 执行耗时
            log.info("执行耗时：{} ms", System.currentTimeMillis() - startTime);
            return ResultUtil.success(result);
        } catch (Throwable throwable) {
            return exceptionHandle.exceptionGet(throwable);
        }
    }

    @After("HandleResult()")
    public void doAfter() {
        log.info("doAfter...");
    }

    /**
     * @return void
     * @description 以json格式打印接口执行结果
     * @param: t
     * @param: res
     */
    @AfterReturning(pointcut = "@annotation(t)", returning = "res")
    public Result afterReturn(HandleResult t, Object res) {
        log.info("接口 {} 被调用已结束, 返回结果为: {} .",
                t.desc(), new Gson().toJson(res));
        Result result = new Result();
        result.setMsg("123");
        result.setCode(2);
        result.setData(res);
        return result;
    }

    @AfterThrowing(throwing = "throwable", pointcut = "HandleResult()")
    public void afterThrowing(Throwable throwable) {
        log.info("After throwing...");
//        log.error("异常信息：", e);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "1");
        map.put("msg", "error");
        map.put("data", throwable);
        log.info("{}", map);
    }

}
