package com.study.spring.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liuyongzhi
 * @description: novel_type表的实体类
 * @date 2019/3/17
 */
@Data
@Entity
@Table(name="novel_type")
public class NovelEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "novelname")
    private String novelName;

    @Column(name = "novelauthor")
    private String novel_author;

    @Column(name = "type")
    private String type;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "download")
    private String download;

}
