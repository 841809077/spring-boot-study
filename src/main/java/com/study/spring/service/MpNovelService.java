package com.study.spring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.spring.entity.NovelEntity;

import java.util.List;

/**
 * @author liuyzh
 * @description
 * @date 2019-10-16
 */
public interface MpNovelService extends IService<NovelEntity> {

    List<NovelEntity> getNovelInfo(String d);
}
