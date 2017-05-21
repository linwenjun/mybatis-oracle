package cn.wenjun.learning.controller;


import cn.wenjun.learning.entity.Blog;
import cn.wenjun.learning.dao.BlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping("/blogs")
    @ResponseBody
    List<Blog> getAllBlog() throws IOException {
        return blogDAO.getAll();
    }

    @RequestMapping("/blogs/{id}")
    @ResponseBody
    Blog getBlogById(@PathVariable("id") Integer id) throws IOException {
        return blogDAO.getById(id);
    }
}
