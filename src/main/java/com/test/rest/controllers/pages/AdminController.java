package com.test.rest.controllers.pages;

import com.test.rest.dao.CategoryDao;
import com.test.rest.dao.ImagesDao;
import com.test.rest.dao.ProductDao;
import com.test.rest.models.Category;
import com.test.rest.models.Image;
import com.test.rest.models.Product;
import com.test.rest.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

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

    @Autowired
    ImagesDao imagesDao;

    @RequestMapping("/")
    public String get(){
        return "admin";
    }

    private static  final  String path = "C:\\Users\\Назар\\Documents\\workfolder-intelij\\shop\\src\\main\\resources\\savedImages\\";

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

    @RequestMapping("/categories/add")
    public ModelAndView addCategory(){
        ModelAndView modelAndView = new ModelAndView("addCategory");
        return modelAndView;
    }

    @RequestMapping(value = "/categories/add", method = RequestMethod.POST)
    public ModelAndView doAddCategory(@RequestParam(value = "name") String name){
        Category category = new Category();

        category.setName(name);
        categoryDao.create(category);

        ModelAndView modelAndView = new ModelAndView("addCategory");
        return modelAndView;
    }

    @RequestMapping("/products/add")
    public ModelAndView addProduct(){
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("categories", categoryDao.getAll());
        return modelAndView;
    }

    @RequestMapping(value= "/products/add", method = RequestMethod.POST)
    public ModelAndView doAddProduct(@RequestParam(value = "categoryId") Integer categoryId,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "description") String description,
                               @RequestParam(value = "file") CommonsMultipartFile avatar,
                               @RequestParam(value = "files", required = false) CommonsMultipartFile[] files){

        Product product = new Product();
        product.setName(name);
        product.setCategory_id(categoryId);
        product.setDescription(description);
        saveAvatar(avatar, product);

        productsDao.create(product);

        saveAllImages(files, product);

        ModelAndView modelAndView = new ModelAndView("addProduct");
        return modelAndView;
    }

    private void saveAllImages(CommonsMultipartFile[] files, Product product){

        if (files != null && files.length > 0 && product.getId() > 0) {
            for (CommonsMultipartFile aFile : files){

                System.out.println("Saving file: " + aFile.getOriginalFilename());


                if (!aFile.getOriginalFilename().equals("")) {
                    try {
                        String fileUri = aFile.getOriginalFilename() + product.getName() + product.getId() + aFile.getSize();
                        aFile.transferTo(new File(path + fileUri));

                        Image image = new Image();
                        image.setTitle(aFile.getOriginalFilename());
                        image.setProduct_id(product.getId());
                        image.setUri(MD5.getMD5(aFile.getOriginalFilename()));

                        imagesDao.create(image);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void saveAvatar(CommonsMultipartFile avatar, Product product){

        System.out.println("Saving file: " + avatar.getOriginalFilename());

        if (!avatar.getOriginalFilename().equals("")) {
            try {
                String fileUri = getUniqueResourceIdentity(avatar, product);

                avatar.transferTo(new File(path + fileUri));

                Image image = new Image();
                image.setTitle(avatar.getOriginalFilename());
                image.setProduct_id(product.getId());
                image.setUri(MD5.getMD5(avatar.getOriginalFilename()));

                imagesDao.create(image);
                product.setImage(image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getUniqueResourceIdentity(CommonsMultipartFile file, Product product) {
        return  MD5.getMD5(file.getOriginalFilename() + product.getName() + product.getId() + file.getSize());
    }
}
