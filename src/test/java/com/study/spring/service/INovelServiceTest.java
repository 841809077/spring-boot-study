package com.study.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Size;

import static org.junit.Assert.*;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/4/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class INovelServiceTest {

    @Autowired
    private INovelService iNovelService;

    @Autowired
    private MpNovelService mpNovelService;

    @Test
    public void aa() {
        log.info("---" + mpNovelService.getNovelInfo("已下载"));
    }

    @Test
    public void getMaxId() {
        log.info("---" + mpNovelService.findMaxId());
    }

    @Test
    public void exist() throws Exception {
        System.out.println("测试");
        boolean exists = iNovelService.exists(3L);
        if (exists) {
            System.out.println("存在");
        }
    }

}