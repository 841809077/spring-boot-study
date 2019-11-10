package com.study.spring.aspect;

import com.study.spring.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.ExcludeSuperclassListeners;
import java.awt.*;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/11/10 0010
 */
@Aspect
@Component
@Order(50)
@Slf4j
public class TestAspect2 {

    @Pointcut("@annotation(com.study.spring.annotation.HandleResult)")
    public void aa(){

    }

    @Before("aa()")
    public void bb(JoinPoint joinPoint){
        log.info("我是 TestAspect2 的 Before 方法...");
    }

    @Around("aa()")
    public Object cc(ProceedingJoinPoint point){
        log.info("我是 TestAspect2 的 Around 方法的前半部分...");
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("我是 TestAspect2 的 Around 方法的后半部分...");
        return result;
    }

    @After("aa()")
    public void doAfter() {
        log.info("我是 TestAspect2 的 After 方法...");
    }

    @AfterReturning("aa()")
    public void afterReturn() {
        log.info("我是 TestAspect2 的 AfterReturning 方法...");
    }

    @AfterThrowing("aa()")
    public void afterThrowing() {
        log.info("我是 TestAspect2 的 AfterThrowing 方法...");
    }
}
