package com.study.spring.listenner;

import com.study.spring.thread.ThreadTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author liuyzh
 * @description https://www.jianshu.com/p/779d31a2d277，http://blog.didispace.com/springbootasync-2/
 * @date 2019-10-10
 */
@Component
public class ListennerTest implements CommandLineRunner {

    @Autowired
    private ThreadTest t;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 12; i++) {
            t.ceshi();
//            t.ceshi2();
//            t.ceshi3();
        }
    }

}
