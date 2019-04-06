package com.study.spring.dao;

import com.study.spring.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuyzh
 * @description: 数据访问层的具体实现
 * @date 2019/3/13 16:01
 */
@Repository
public class UsersDaoImpl implements UsersDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UsersEntity> usersList() {
        List<UsersEntity> list = jdbcTemplate.query("select * from user_manage", new Object[]{}, new BeanPropertyRowMapper(UsersEntity.class));
        return list;
    }

    @Override
    public UsersEntity findUserOne(String name) {
        List<UsersEntity> list = jdbcTemplate.query("select * from user_manage where user_name = ?", new Object[]{name}, new BeanPropertyRowMapper(UsersEntity.class));
        if (list != null && list.size() > 0) {
            UsersEntity usersEntity = list.get(0);
            return usersEntity;
        } else {
            return null;
        }
    }

    @Override
    public void saveUser(UsersEntity usersEntity) {
        jdbcTemplate.update("insert into user_manage(user_name, password, telPhone) values(?, ?, ?)",
                usersEntity.getUserName(), usersEntity.getPassword(), usersEntity.getTelPhone());
    }

    @Override
    public void updateUser(UsersEntity usersEntity) {
        jdbcTemplate.update("UPDATE user_manage SET password=?, telPhone=? WHERE user_name=?",
                usersEntity.getPassword(), usersEntity.getTelPhone(), usersEntity.getUserName());
    }

    @Override
    public void removeUser(String name) {
        jdbcTemplate.update("DELETE FROM user_manage WHERE user_name = ?", name);
    }
}
