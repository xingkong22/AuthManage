package com.ydx.test.service;

import com.ydx.test.dao.CategoryDao;
import com.ydx.test.pojo.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Resource
    private CategoryDao dao;

    public List<Category> showAllCategory() {
        return dao.showAllCategory();
    }

    public void deleteCategory(String s) {
        dao.deleteCategory(s);
    }
}
