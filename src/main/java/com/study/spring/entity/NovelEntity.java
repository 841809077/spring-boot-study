package com.study.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liuyongzhi
 * @description: novel_type表的实体类
 * @date 2019/3/17
 */
@Entity
@Table(name="novel_type")
public class NovelEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "novelname")
    private String novelName;

    @Column(name = "novelauthor")
    private String novelAuthor;

    @Column(name = "type")
    private String type;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "download")
    private String download;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getNovelAuthor() {
        return novelAuthor;
    }

    public void setNovelAuthor(String novelAuthor) {
        this.novelAuthor = novelAuthor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    @Override
    public String toString() {
        return "NovelEntity{" +
                "id=" + id +
                ", novelName='" + novelName + '\'' +
                ", novelAuthor='" + novelAuthor + '\'' +
                ", type='" + type + '\'' +
                ", introduce='" + introduce + '\'' +
                ", download='" + download + '\'' +
                '}';
    }
}
