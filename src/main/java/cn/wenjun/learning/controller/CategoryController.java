package cn.wenjun.learning.controller;


import cn.wenjun.learning.dao.CategoryDAO;
import cn.wenjun.learning.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryDAO categoryDao;

    @RequestMapping("/")
    public Category getById(Integer id) {
        Category result= categoryDao.getById(1);

        return result;
    }
}
