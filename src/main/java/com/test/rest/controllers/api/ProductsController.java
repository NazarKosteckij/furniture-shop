package com.test.rest.controllers.api;

import com.test.rest.dao.ProductDao;
import com.test.rest.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Nazar on 16.01.2016.
 */
@Controller
@RequestMapping(value = "api/products")
public class ProductsController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/")
    public @ResponseBody   List<Product> getAll(){
     return productDao.getAll();
    }
}
