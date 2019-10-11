package com.study.spring;

import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

/**
 * @author liuyzh
 * @description: main()方法加载日志配置测试
 * @date 2019/8/21 10:03
 */
public class LogbackTest {
    
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);


    public static void test(){
        logger.info("info");
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
    }

    public static void main(String[] args) throws IOException, JoranException {
        LogBackConfigLoader.load(Objects.requireNonNull(LogbackTest.class.getClassLoader().getResource("logback-spring.xml")).getPath());
        test();
    }
    
}
