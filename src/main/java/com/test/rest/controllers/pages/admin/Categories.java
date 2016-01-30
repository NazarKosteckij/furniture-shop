package com.test.rest.controllers.pages.admin;

import com.test.rest.dao.CategoryDao;
import com.test.rest.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nazar Kostetskiy on 29.01.2016.
 */
@Controller
@RequestMapping("admin")
public class Categories {

    @Autowired
    CategoryDao categoryDao;

    @RequestMapping("/categories")
    public ModelAndView categories(){
        ModelAndView modelAndView = new ModelAndView("categories");
        modelAndView.addObject("categories", categoryDao.getAll());
        return modelAndView;
    }

    @RequestMapping("/categories/add")
    public ModelAndView addCategory(){
        ModelAndView modelAndView = new ModelAndView("addCategory");
        return modelAndView;
    }


    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public ModelAndView editCategory(@PathVariable Integer id) {
        Category category = categoryDao.read(id);
        ModelAndView modelAndView = new ModelAndView("addCategory");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.POST)
    public String doUpdateCategory(@PathVariable Integer id, @RequestParam(value = "name") String name){
        Category category = categoryDao.read(id);

        category.setName(name);
        categoryDao.update(category);

        return "redirect:../categories/";
    }


    @RequestMapping(value = "/categories/add", method = RequestMethod.POST)
    public ModelAndView doAddCategory(@RequestParam(value = "name") String name){
        Category category = new Category();

        category.setName(name);
        categoryDao.create(category);

        ModelAndView modelAndView = new ModelAndView("addCategory");
        return modelAndView;
    }
}
