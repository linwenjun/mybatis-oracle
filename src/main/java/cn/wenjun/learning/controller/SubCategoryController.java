package cn.wenjun.learning.controller;


import cn.wenjun.learning.dao.CategoryDAO;
import cn.wenjun.learning.entity.Category;
import cn.wenjun.learning.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@RestController
public class SubCategoryController {

    @Autowired
    private CategoryDAO categoryDao;

    @RequestMapping(value="/subcategory", method = RequestMethod.POST)
    public Category getById(ArrayList<SubCategory> subCategoryList) {

        Category result= categoryDao.getById(1);

        return result;
    }
}
