package cn.wenjun.learning.services;

import cn.wenjun.learning.Blog;
import cn.wenjun.learning.dao.BlogDAO;

import java.util.List;

public class BlogService {

    private BlogDAO blogDAO;

    public BlogDAO getBlogDAO() {
        return blogDAO;
    }

    public void setBlogDAO(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    public List<Blog> getAll() {
        return blogDAO.getAll();
    }
}
