package com.ydx.test.controller;

import com.ydx.test.pojo.Category;
import com.ydx.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;
    @RequestMapping("showAllCategory")
    public List<Category> showAllCategory() {
        return service.showAllCategory();
    }
    @RequestMapping("deleteCategory")
    public String deleteCategory(@RequestBody String s) {

        service.deleteCategory(s);
        return "1";
    }



}
