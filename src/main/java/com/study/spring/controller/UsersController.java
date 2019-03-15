package com.study.spring.controller;

import com.study.spring.entity.UsersEntity;
import com.study.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuyzh
 * @description:
 * @date 2019/3/13 16:57
 */
@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * @description: 获取表中所有信息。
     * @return: java.util.List<com.study.spring.entity.UsersEntity>
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<UsersEntity> list() {
        return usersService.usersList();
    }
    
    /**
     * @description: 通过name来查询信息
     * @param: name
     * @return: com.study.spring.entity.UsersEntity
     */
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public UsersEntity findUserOne(@PathVariable("name") String name){
        return usersService.findUserOne(name);
    }

    /**
     * @description: 向表中插入一条数据
     * @param: usersEntity
     * @return: java.util.Map<java.lang.String,java.lang.Boolean>
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Map<String,Boolean> save(UsersEntity usersEntity) {
        Map<String,Boolean> map = new HashMap<>();
        try {
            usersService.saveUser(usersEntity);
            map.put("status",true);
        } catch (Exception e) {
            map.put("status",false);
        }
        return map;
    }

    /**
     * @description: 更新表中数据
     * @return: void
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Map<String,Boolean> update(UsersEntity usersEntity) {
        Map<String,Boolean> map = new HashMap<>();
        try {
            usersService.updateUser(usersEntity);
            map.put("status",true);
        } catch (Exception e) {
            map.put("status",false);
        }
        return map;
    }

    @RequestMapping(value = "remove", method = RequestMethod.DELETE)
    public Map<String,Boolean> remove(@RequestParam(value = "userName",required = true) String name) {
        Map<String,Boolean> map = new HashMap<>();
        try {
            usersService.removeUser(name);
            map.put("status",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
        }
        return map;
    }
}
