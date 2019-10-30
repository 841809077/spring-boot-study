package com.study.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.spring.entity.NovelEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author liuyzh
 * @description
 * @date 2019-10-15
 */
@Component
public interface NovelMapper extends BaseMapper<NovelEntity> {

    @Select("SELECT * from novel_type WHERE download = #{d123} and type = #{ttt}")
    List<NovelEntity> getNovelInfo(String d123, String ttt);

    @Update("UPDATE novel_type SET novelauthor = #{na} WHERE novelname = #{nn}")
    int updateNovelInfo(@Param("nn") String novelName, @Param("na") String novelAuthor);

    @Insert("INSERT INTO novel_type (`novelname`, `novelauthor`, `type`, `introduce`, `download`) " +
            "VALUES (#{novelName}, #{novel_author}, #{type}, #{introduce}, #{download})")
    int saveNovelInfo(NovelEntity novelEntity);

    @Delete("DELETE FROM novel_type WHERE novelname = #{novelName}")
    int deleteNovelInfo(String novelName);

    Integer findMaxId();

    List<NovelEntity> getDownloadList(@Param("query") Map<String, String> map);

    void saveNovel(NovelEntity novelEntity);

    int updateNovelByName(NovelEntity novelEntity);

    int deleteNoveBy(NovelEntity novelEntity);

}
