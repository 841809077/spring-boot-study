package com.study.spring.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author liuyzh
 * @description
 * @date 2019-10-10
 */
@Component
@Slf4j
public class ThreadTest {

    @Async("asyncTaskExecutor")
    public void ceshi() {
        log.info("ceshi");
    }

    @Async("asyncTaskExecutor")
    public void ceshi2() {
        log.info("ceshi2");
    }

    @Async("asyncTaskExecutor")
    public void ceshi3() {
        log.info("ceshi3");
    }

}
