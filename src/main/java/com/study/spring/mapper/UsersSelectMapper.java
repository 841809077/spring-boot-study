package com.study.spring.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.study.spring.entity.UsersEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Liuyongzhi
 * @description:
 * @date 2019/10/14 0014
 */
public interface UsersSelectMapper extends BaseMapper<UsersEntity> {

//    List<UsersEntity> selectByName(@Param(Constants.WRAPPER) Wrapper<UsersEntity> userWrapper);

}
