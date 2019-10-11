//package com.study.spring.listenner;
//
//import com.study.spring.thread.ThreadTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @author Liuyongzhi
// * @description:
// * @date 2019/10/11 0011
// */
//@Component
//public class listennerTest3 {
//
//    @Autowired
//    private ThreadTest t;
//
//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            t.ceshi();
//        }
//    }
//
//}
