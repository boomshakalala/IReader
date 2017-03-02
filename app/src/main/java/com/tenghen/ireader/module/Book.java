package com.tenghen.ireader.module;

import java.io.Serializable;

/**
 * 作者：chengx
 * 日期：2017/2/24
 * 描述：
 */

public class Book implements Serializable{
    private String id;
    private String name;
    private String cover;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
