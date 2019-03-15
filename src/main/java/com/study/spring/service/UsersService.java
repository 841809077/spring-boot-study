package com.study.spring.service;

import com.study.spring.entity.UsersEntity;

import java.util.List;

/**
 * @author liuyzh
 * @description:
 * @date 2019/3/13 16:08
 */
public interface UsersService {

    /**
     * @description: 获取表中所有信息。
     * @return: java.util.List<com.study.spring.entity.UsersEntity>
     */
    List<UsersEntity> usersList();

    /**
     * @description: 通过name来查询信息
     * @param: name
     * @return: com.study.spring.entity.UsersEntity
     */
    UsersEntity findUserOne(String name);

    /**
     * @description: 向表中插入一条数据
     * @param: usersEntity
     * @return: void
     */
    void saveUser(UsersEntity usersEntity);

    /**
     * @description: 更新表中单条数据
     * @param: usersEntity
     * @return: void
     */
    void updateUser(UsersEntity usersEntity);

    /**
     * @description: 删除表中单条数据
     * @param: name
     * @return: void
     */
    void removeUser(String name);
}
