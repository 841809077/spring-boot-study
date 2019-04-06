package com.study.spring.controller;

import com.study.spring.entity.NovelEntity;
import com.study.spring.service.INovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liuyongzhi
 * @description: 控制层，关联业务层，制作api
 * @date 2019/3/17
 */
@RestController
@RequestMapping("novel")
public class NovelController {

    @Autowired
    private INovelService iNovelService;

    /**
     * @description: 获取表中所有信息
     * @return: java.util.List<com.study.spring.entity.NovelEntity>
     */
    @RequestMapping("list")
    public List<NovelEntity> findAll() {
        return iNovelService.findAll();
    }

    /**
     * @description: 获取表中所有数据的个数
     * @return: long
     */
    @RequestMapping("count")
    public long count() {
        return iNovelService.count();
    }

    /**
     * @description: 向表中插入或更新一条数据
     * @param: novelEntity
     * @return: java.util.Map<java.lang.String,java.lang.Boolean>
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Map<String, Boolean> saveNovel(NovelEntity novelEntity) {
        Map<String, Boolean> map = new HashMap<>();
        try {
            iNovelService.saveNovel(novelEntity);
            map.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", false);
        }
        return map;
    }

    /**
     * @description: 通过小说作者和小说类型来查询数据
     * @param: author（小说作者），在url中可不指明author参数，默认值为“天蚕土豆”
     * @param: type（小说类型），在url中必须指明type参数
     * @return: java.util.List<com.study.spring.entity.NovelEntity>
     */
    @RequestMapping(value = "findByAuthorAndType", method = RequestMethod.GET)
    public List<NovelEntity> findByAuthorAndType(@RequestParam(value = "author", required = false, defaultValue = "天蚕土豆") String author,
                                                 @RequestParam(value = "type") String type) {
        List<NovelEntity> neList;
        neList = iNovelService.findByAuthorAndType(author, type);
        return neList;
    }

    /**
     * @description: 根据表的id来删除数据
     * @param: id
     * @return: java.util.Map<java.lang.String,java.lang.Boolean>
     */
    @RequestMapping(value = "id/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteById(@PathVariable("id") Long id) {
        Map<String, Boolean> map = new HashMap<>();
        // 根据id判断数据是否存在
        boolean exists = iNovelService.exists(id);
        try {
            if (exists) {
                // 如果数据存在，则删除该数据。
                iNovelService.deleteById(id);
                map.put("status", true);
            } else {
                map.put("status", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", false);
        }
        return map;
    }

    /**
     * @description: 根据小说名称来删除数据
     * @param: novelName
     * @return: java.util.Map<java.lang.String,java.lang.Boolean>
     */
    @RequestMapping(value = "deleteByNovelName", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteByNovelName(@RequestParam(value = "novelName", required = false) String novelName) {
        Map<String, Boolean> map = new HashMap<>();
        try {
            iNovelService.deleteByNovelName(novelName);
            map.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", false);
        }
        return map;
    }
}
