package com.study.spring.listenner;

import com.study.spring.thread.ThreadTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author liuyzh
 * @description 程序启动就执行异步多线程
 * @date 2019-10-10
 */
//@Component
public class ListennerTest implements CommandLineRunner {

    @Autowired
    private ThreadTest t;

    @Override
    public void run(String... args) {
        for (int i = 1; i <= 10; i++) {
            t.ceshi();
        }
    }
}
