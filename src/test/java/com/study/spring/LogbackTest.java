package com.study.spring;

import ch.qos.logback.core.joran.spi.JoranException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Objects;

/**
 * @author liuyzh
 * @description: 测试类加载日志配置测试
 * @date 2019/8/21 10:03
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class LogbackTest {
    
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test(){
        try {
            LogBackConfigLoader.load(Objects.requireNonNull(LogbackTest.class.getClassLoader().getResource("logback-spring.xml")).getPath());
        } catch (IOException | JoranException e) {
            e.printStackTrace();
        }
        logger.info("info123");
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
    }
    
}
