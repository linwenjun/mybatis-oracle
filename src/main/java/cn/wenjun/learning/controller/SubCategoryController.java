package cn.wenjun.learning.controller;


import cn.wenjun.learning.dao.CategoryDAO;
import cn.wenjun.learning.dao.SubCategoryDAO;
import cn.wenjun.learning.entity.Category;
import cn.wenjun.learning.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("unused")
@RestController
public class SubCategoryController {

    @Autowired
    private CategoryDAO categoryDao;

    @Autowired
    private SubCategoryDAO subCategoryDAO;

    @RequestMapping(value="/subcategory", method = RequestMethod.POST)
    public Category getById(@RequestBody List<SubCategory> subCategoryList) {
        subCategoryDAO.bulkCreate(subCategoryList);

        Category result= categoryDao.getById(1);

        return result;
    }
}
