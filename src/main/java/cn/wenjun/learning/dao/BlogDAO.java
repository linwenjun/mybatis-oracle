package cn.wenjun.learning.dao;

import cn.wenjun.learning.entity.Blog;

import java.util.List;

public interface BlogDAO {
    List<Blog> getAll();

    Blog getById(Integer id);
}
