package cn.wenjun.learning.entity;

import lombok.Data;

import java.util.Date;

public @Data class Blog {
    private int id;
    private String name;
    private Date updateAt;
}
