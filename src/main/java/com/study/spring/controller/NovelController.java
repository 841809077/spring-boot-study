package com.study.spring.controller;

import com.study.spring.aspect.WebLog;
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
    @WebLog()
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
     * @description: 向表中批量插入或更新数据
     * POST http://localhost:8081/spring-boot-study/novel/saveBatchNovel
     * body: [{"id": 1,"novelName": "斗罗大陆","novelAuthor": "唐家三少","type": "已完结","introduce": "斗罗大陆出新手游啦~","download": "true"},{"id": 2,"novelName": "斗破苍穹","novelAuthor": "天蚕土豆","type": "已完结","introduce":"这里是属于斗气的世界，没有花俏艳丽的魔法，有的，仅仅是繁衍到巅峰的斗气！新书等级制度：斗者，斗师，大斗师，斗灵，斗王，斗皇，斗宗，斗尊，斗圣，斗帝。","download": "true"}]
     * @param: novelEntityList
     * @return: java.util.Map<java.lang.String,java.lang.Boolean>
     */
    @RequestMapping(value = "saveBatchNovel", method = RequestMethod.POST)
    public Map<String, Boolean> saveBatchNovel(@RequestBody List<NovelEntity> novelEntityList) {
        Map<String, Boolean> map = new HashMap<>();
        try {
            iNovelService.saveBatchNovel(novelEntityList);
            map.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", false);
        }
        return map;
    }

    /**
     * @description: 测试前端json数据传递到非实体类中，body里面的json数据怎么解析
     * @param: mapList
     * @return: java.lang.String
     */
    @RequestMapping(value = "testBody", method = RequestMethod.POST)
    public String testBody(@RequestBody List<Map<String, String>> mapList) {
        // 仅获取数组第一条数据的noveName值
        System.out.println(mapList.get(0).get("novelName"));
        // 两层for循环，得到每条数据的key值与value值
        for (Map<String, String> map : mapList) {
            System.out.println(map);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("key = " + entry.getKey() + " , value = " + entry.getValue());
            }
        }
        return null;
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
    public Map<String, Boolean> deleteByNovelName(@RequestBody NovelEntity ne) {
        Map<String, Boolean> map = new HashMap<>();
        try {
            iNovelService.deleteByNovelName(ne.getNovelName());
            map.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", false);
        }
        return map;
    }
    
    /**
     * @description: 批量删除表数据
     * DELETE http://localhost:8081/spring-boot-study/novel/deleteBatchNovel
     * body: [{"id": 1},{"id": 2}] ，也可以将所有字段都指出。
     * @param: novelEntityList
     * @return: java.util.Map<java.lang.String,java.lang.Boolean>
     */
    @RequestMapping(value = "deleteBatchNovel", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteBatchNovel(@RequestBody List<NovelEntity> novelEntityList) {
        Map<String, Boolean> map = new HashMap<>();
        try {
            iNovelService.deleteBatchNovel(novelEntityList);
            map.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", false);
        }
        return map;
    }
}
