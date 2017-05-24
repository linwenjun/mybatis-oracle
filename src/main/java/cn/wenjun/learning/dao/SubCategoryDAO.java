package cn.wenjun.learning.dao;

import cn.wenjun.learning.entity.Category;
import cn.wenjun.learning.entity.SubCategory;

import java.util.List;

public interface SubCategoryDAO {
    Integer bulkCreate(List<SubCategory> subCategoryList);
}
