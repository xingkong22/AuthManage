package com.ydx.test.dao;

import com.ydx.test.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CategoryDao {
    List<Category> showAllCategory();

    void deleteCategory(String s);
}
