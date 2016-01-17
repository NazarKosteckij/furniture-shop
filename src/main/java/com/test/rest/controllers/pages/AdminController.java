package com.test.rest.controllers.pages;

import com.test.rest.dao.CategoryDao;
import com.test.rest.dao.ProductDao;
import com.test.rest.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nazar on 16.01.2016.
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ProductDao productsDao;


    @RequestMapping("/categories")
    public ModelAndView categories(){
        ModelAndView modelAndView = new ModelAndView("categories");
        modelAndView.addObject("categories", categoryDao.getAll());
        return modelAndView;
    }

    @RequestMapping("/products")
    public ModelAndView products(){
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productsDao.getAll());
        return modelAndView;
    }


    @RequestMapping("/")
    public String get(){
        return "admin";
    }

    @RequestMapping("/products/add")
    public ModelAndView addProduct(){
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("categories", categoryDao.getAll());
        return modelAndView;
    }

    @RequestMapping(value= "/products/add", method = RequestMethod.POST)
    public String doAddProduct(@RequestParam(value = "categoryId") Integer categoryId,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "description") String description){
        System.out.print(description + "\n" + name + "\n" + categoryId);
        Product product = new Product();

        product.setName(name);
        product.setCategory_id(categoryId);
        product.setDescription(description);

        return "admin";
    }
}
