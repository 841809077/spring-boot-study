package com.study.spring.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuyzh
 * @description
 * @date 2019-10-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadRunTest {

    @Autowired
    private ThreadTest t;

    @Test
    public void thread1() {
        for (int i = 1; i <= 10; i++) {
            t.ceshi4();
        }
    }
}
