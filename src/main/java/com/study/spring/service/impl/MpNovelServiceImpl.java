package com.study.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.spring.entity.NovelEntity;
import com.study.spring.mapper.NovelMapper;
import com.study.spring.service.MpNovelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyzh
 * @description
 * @date 2019-10-16
 */
@Service
public class MpNovelServiceImpl extends ServiceImpl<NovelMapper, NovelEntity> implements MpNovelService {
    @Override
    public List<NovelEntity> getNovelInfo(String d) {
        return baseMapper.getNovelInfo(d);
    }
}
