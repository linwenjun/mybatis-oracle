package cn.wenjun.learning.controller;


import cn.wenjun.learning.dao.BlogDAO;
import cn.wenjun.learning.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    ResponseEntity getBlogById(@PathVariable("id") Integer id) throws IOException {

        Blog result = blogDAO.getById(id);
        return ResponseEntity.ok(result);
    }
}
