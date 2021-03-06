package com.study.spring.service;

import com.study.spring.annotation.HandleResult;
import com.study.spring.entity.NovelEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

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
    @HandleResult
    public void getDownloadList() {
        Map<String, String> map = new HashMap<>();
        map.put("dl", "已下载");
        map.put("nu", "金庸");
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
        novelEntity.setNovel_author("辰东");
//        novelEntity.setIntroduce("热销作品");
        novelEntity.setType("已完结");
//        novelEntity.setDownload("true");
        mpNovelService.saveNovel(novelEntity);
    }

    @Test
    public void deleteNovelInfo() {
        int deleteCount = mpNovelService.deleteNovelInfo("遮天");
        log.info("deleteCount: " + deleteCount);
    }

    @Test
    public void updateNovel(){
        NovelEntity novelEntity = new NovelEntity();
        novelEntity.setNovelName("遮天");
        novelEntity.setNovel_author("辰东");
//        novelEntity.setIntroduce("热销作品");
//        novelEntity.setType("已完结");
//        novelEntity.setDownload("true");
        int aa = mpNovelService.updateNovelByName(novelEntity);
        System.out.println(aa);
    }

    @Test
    public void deleteNoveByName(){
        NovelEntity novelEntity = new NovelEntity();
        novelEntity.setNovelName("遮天");
//        novelEntity.setNovel_author("辰东");
//        novelEntity.setIntroduce("热销作品");
//        novelEntity.setType("已完结");
//        novelEntity.setDownload("true");
        int aa = mpNovelService.deleteNoveBy(novelEntity);
        System.out.println(aa);
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