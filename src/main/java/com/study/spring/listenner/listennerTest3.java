package com.study.spring.listenner;

import com.study.spring.thread.ThreadTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Liuyongzhi
 * @description: 定时任务触发异步多线程
 * @date 2019/10/11
 */
//@Component
public class listennerTest3 {

    @Autowired
    private ThreadTest t;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        t.ceshi3();
    }
}
