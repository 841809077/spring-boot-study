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
        for (int i = 0; i < 3; i++) {
            log.info("ceshi2");
        }
    }

    /**
     * 每10秒循环一次，一个线程共循环10次。
     */
    @Async("asyncTaskExecutor")
    public void ceshi3() {
        for (int i = 0; i < 10; i++) {
            log.info("ceshi3: " + i);
            try {
                Thread.sleep(2000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async("asyncTaskExecutor")
    public void ceshi4() {
        log.info("ceshi4");
    }
}
