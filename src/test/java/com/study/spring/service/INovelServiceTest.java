package com.study.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/4/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class INovelServiceTest {

    @Autowired
    private INovelService iNovelService;

    @Test
    public void exist() throws Exception {
        System.out.println("测试");
        boolean exists = iNovelService.exists(3L);
        if(exists){
            System.out.println("存在");
        }
    }

}