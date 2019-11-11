package com.study.spring.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.study.spring.entity.NovelEntity;
import com.study.spring.jpa.INovelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liuyongzhi
 * @description: 业务层的具体实现，在该类里面关联数据层
 * @date 2019/3/17
 */
@Service
@DS("db2")
public class NovelServiceImpl implements INovelService {

    @Autowired
    private INovelDAO inovelDAO;

    @Override
    public List<NovelEntity> findAll() {
        return inovelDAO.findAll();
    }

    @Override
    public List<NovelEntity> findByAuthorAndType(String author, String type) {
        return inovelDAO.findByAuthorAndType(author, type);
    }

    @Override
    public long count() {
        return inovelDAO.count();
    }

    @Override
    public void saveNovel(NovelEntity novelEntity) {
        inovelDAO.save(novelEntity);
    }

    @Override
    public void saveBatchNovel(List<NovelEntity> novelEntityList) {
        inovelDAO.saveAll(novelEntityList);
    }

    @Override
    public boolean exists(Long id) {
        return inovelDAO.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        inovelDAO.deleteById(id);
    }

    @Override
    public void deleteByNovelName(String novelName) {
        inovelDAO.deleteByNovelName(novelName);
    }

    @Override
    public void deleteBatchNovel(List<NovelEntity> novelEntityList) {
        inovelDAO.deleteAll(novelEntityList);
    }
}
