package com.study.spring.service;

import com.study.spring.entity.NovelEntity;

import java.util.List;

/**
 * @author Liuyongzhi
 * @description: 业务层
 * @date 2019/3/17
 */
public interface INovelService {
    
    /**
     * @description: 获取表中所有信息
     * @return: java.util.List<com.study.spring.entity.NovelEntity>
     */
    List<NovelEntity> findAll();

    /**
     * @description: 通过小说作者和小说类型来查询数据
     * @param: author（小说作者）
     * @param: type（小说类型）
     * @return: java.util.List<com.study.spring.entity.NovelEntity>
     */
    List<NovelEntity> findByAuthorAndType(String author, String type);
    
    /**
     * @description: 获取表中所有数据的个数
     * @return: long
     */
    long count();
    
    /**
     * @description: 向表中插入或更新一条数据
     * @param: novelEntity
     * @return: void
     */
    void saveNovel(NovelEntity novelEntity);
    
    /**
     * @description: 根据id判断数据是否存在
     * @param: id
     * @return: boolean
     */
    boolean exists(Long id);

    /**
     * @description: 根据表的id来删除数据
     * @param: id
     * @return: void
     */
    void deleteById(Long id);
    
    /**
     * @description: 根据小说名称来删除数据
     * @param: novelName（小说名称）
     * @return: void
     */
    void deleteByNovelName(String novelName);

}
