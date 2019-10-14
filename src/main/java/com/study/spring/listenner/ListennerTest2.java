package com.study.spring.listenner;

import com.study.spring.thread.ThreadTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyzh
 * @description 接口形式触发异步多线程
 * @date 2019-10-11
 */
@RestController
@RequestMapping("thread")
public class ListennerTest2 {

    @Autowired
    private ThreadTest t;

    @GetMapping("dingshi")
    public void run() {
        for (int i = 1; i < 10; i++) {
            t.ceshi2();
        }
    }
}
