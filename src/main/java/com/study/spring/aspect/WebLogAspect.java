package com.study.spring.aspect;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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
    public void doBefore(JoinPoint joinPoint) throws Exception {
        String desc = getAspectLogDescription(joinPoint);
        log.info("doBefore...");
        log.info(desc);
    }

    @After("WebLog()")
    public void doAfter(){
        log.info("doAfter...");
    }

    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(WebLog.class).desc());
                    break;
                }
            }
        }
        return description.toString();
    }
}
