package com.study.spring;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.junit.runners.model.InitializationError;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;

/**
 * @author liuyzh
 * @description:
 * @date 2019/8/21 13:17
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {

    static{
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure(Objects.requireNonNull(LogbackTest.class.getClassLoader().getResource("logback-spring.xml")).getPath());
        } catch (JoranException e) {
            e.printStackTrace();
        }
    }

    public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
}
