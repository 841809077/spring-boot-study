package com.study.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.spring.entity.NovelEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liuyzh
 * @description
 * @date 2019-10-15
 */
public interface NovelMapper extends BaseMapper<NovelEntity> {

    @Select("select * from novel_type where download = #{d}")
    List<NovelEntity> getNovelInfo(String d);

}
