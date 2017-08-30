package cn.wenjun.learning.dao;

import cn.wenjun.learning.entity.Blog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogDAO {
    List<Blog> getAll();

    Blog getById(Integer id);

    @Transactional
    Integer create(Blog blog);
}
