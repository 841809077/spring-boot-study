package com.study.spring.service;

import com.study.spring.entity.NovelEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Size;

import java.util.HashMap;
import java.util.Map;

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
        log.info("---" + mpNovelService.getNovelInfo("已下载", "已完结"));
    }

    @Test
    public void getMaxId() {
        log.info("---" + mpNovelService.findMaxId());
    }

    @Test
    public void getDownloadList() {
        Map<String, String> map = new HashMap<>();
        map.put("dl", "true");
        log.info("---" + mpNovelService.getDownloadList(map));
    }

    @Test
    public void updateNovelInfo() {
        int updateCount = mpNovelService.updateNovelInfo("遮天", "辰东er");
        log.info(String.valueOf(updateCount));
    }

    @Test
    public void saveNovelInfo() {
        NovelEntity novelEntity = new NovelEntity();
        novelEntity.setNovelName("遮天");
        novelEntity.setNovelAuthor("唐家三少");
        novelEntity.setIntroduce("热销作品");
        novelEntity.setType("已完结");
//        novelEntity.setDownload("true");
        int saveCount = mpNovelService.saveNovelInfo(novelEntity);
        log.info("saveCount: " + saveCount);
    }

    @Test
    public void deleteNovelInfo() {
        int deleteCount = mpNovelService.deleteNovelInfo("遮天");
        log.info("deleteCount: " + deleteCount);
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