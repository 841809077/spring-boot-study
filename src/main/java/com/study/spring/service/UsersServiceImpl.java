package com.study.spring.service;

import com.study.spring.dao.UsersDAO;
import com.study.spring.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyzh
 * @description:
 * @date 2019/3/13 16:10
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDao;

    @Override
    public List<UsersEntity> usersList() {
        return usersDao.usersList();
    }

    @Override
    public UsersEntity findUserOne(String name) {
        return usersDao.findUserOne(name);
    }

    @Override
    public void saveUser(UsersEntity usersEntity) {
        usersDao.saveUser(usersEntity);
    }

    @Override
    public void updateUser(UsersEntity usersEntity) {
        usersDao.updateUser(usersEntity);
    }

    @Override
    public void removeUser(String name) {
        usersDao.removeUser(name);
    }
}
