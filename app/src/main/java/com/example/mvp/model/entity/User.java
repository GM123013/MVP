package com.example.mvp.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by GM on 2018/8/13.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String content;
    private String img;
    @Generated(hash = 1543190564)
    public User(Long id, String name, String content, String img) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.img = img;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
