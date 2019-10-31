package com.study.spring.aspect;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/10/31 0031
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("@annotation(com.study.spring.aspect.WebLog)")
    public void WebLog() {
    }

    /**
     * @description 定义@Around环绕，用于何时执行切点
     * @param: proceedingJoinPoint
     * @return java.lang.Object
     */
    @Around("WebLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 执行切点。执行切点后，会去依次调用 @Before -> 接口逻辑代码 -> @After -> @AfterReturning；
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("Response Args: {}", new Gson().toJson(result));
        // 执行耗时
        log.info("执行耗时：{}", System.currentTimeMillis() - startTime);
        return result;
    }

    @Before("WebLog()")
    public void doBefore(JoinPoint joinPoint){
        log.info("doBefore...");
    }

    @After("WebLog()")
    public void doAfter(){
        log.info("doAfter...");
    }
}
