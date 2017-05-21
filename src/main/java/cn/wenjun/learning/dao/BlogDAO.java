package cn.wenjun.learning.dao;

import cn.wenjun.learning.Blog;

import java.util.List;

public interface BlogDAO {
    Blog getOne(int id);

    List<Blog> getAll();
}
