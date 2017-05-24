package cn.wenjun.learning.entity;

import java.util.Date;

public class Category {
    private int id;
    private String name;
    private Date updateAt;
    private Category origin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Category getOrigin() {
        return origin;
    }

    public void setOrigin(Category origin) {
        this.origin = origin;
    }
}
