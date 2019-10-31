package com.study.spring.aspect;

import java.lang.annotation.*;

/**
 * @author Liuyongzhi
 * @description: 自定义日志注解
 * @date 2019/10/31 0031
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {

    String desc() default "create17";

}
