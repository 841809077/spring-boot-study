package com.study.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.spring.entity.UsersEntity;
import com.study.spring.mapper.UsersSelectMapper;
import com.study.spring.service.UsersSelectService;
import com.study.spring.service.UsersService;
import org.springframework.stereotype.Service;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/10/14 0014
 */
@Service
public class UsersSelectServiceImpl extends ServiceImpl<UsersSelectMapper, UsersEntity> implements UsersSelectService {
}
