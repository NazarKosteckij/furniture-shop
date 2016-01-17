package com.test.rest.controllers.api;

import com.test.rest.dao.CategoryDao;
import com.test.rest.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Nazar on 16.01.2016.
 */
@Controller
@RequestMapping(value = "api/categories")
public class CategoriesController {
    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "/")
    public @ResponseBody List<Category> getAll(){
        return categoryDao.getAll();
    }
}
