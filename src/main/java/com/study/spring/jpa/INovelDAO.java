package com.study.spring.jpa;

import com.study.spring.entity.NovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Liuyongzhi
 * @date 2019/3/17
 * @description: 创建Novel JPA接口，继承SpringDataJPA内的接口作为父类。
 * 继承JpaRepository接口（SpringDataJPA提供的简单数据操作接口）、
 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）
 */
public interface INovelDAO extends JpaRepository<NovelEntity, Long>,
        JpaSpecificationExecutor<NovelEntity>
{
    
    /**
     * @description: 通过小说作者来查询数据
     * @param: author（小说作者）
     * @param: type（小说类型）
     * @return: java.util.List<com.study.spring.entity.NovelEntity>
     */
    @Query("select nt from NovelEntity nt where nt.novel_author = ?1 and nt.type = ?2")
    List<NovelEntity> findByAuthorAndType(String author, String type);

    /**
     * @description: 根据小说名称来删除数据
     * @param: novelName（小说名称）
     * @return: void
     */
    @Transactional
    @Modifying
    @Query("delete from NovelEntity nt where nt.novelName = ?1")
    void deleteByNovelName(String novelName);

}
