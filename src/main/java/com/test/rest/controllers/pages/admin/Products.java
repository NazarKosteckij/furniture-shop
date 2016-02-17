package com.test.rest.controllers.pages.admin;

import com.test.rest.dao.CategoryDao;
import com.test.rest.dao.ImagesDao;
import com.test.rest.dao.ProductDao;
import com.test.rest.models.Image;
import com.test.rest.models.Product;
import com.test.rest.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Nazar Kostetskiy on 29.01.2016.
 */
@Controller
@RequestMapping("admin")
public class Products {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productsDao;

    @Autowired
    private ImagesDao imagesDao;

    private static final ResourceBundle resourceBundle = ResourceBundle.
            getBundle("folders");

    private static final String PATH = resourceBundle.getString("file.images.location");

    @RequestMapping("/products")
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productsDao.getAll());
        return modelAndView;
    }


    @RequestMapping("/products/add")
    public ModelAndView addProduct() {
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("categories", categoryDao.getAll());
        return modelAndView;
    }

    @RequestMapping(value= "/products/add", method = RequestMethod.POST)
    public String doAddProduct(@RequestParam(value = "categoryId") Integer categoryId,
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "description") String description,
                                     @RequestParam(value = "file") CommonsMultipartFile avatar,
                                     @RequestParam(value = "files", required = false) CommonsMultipartFile[] files) {

        Product product = new Product();
        product.setName(name);
        product.setCategory_id(categoryId);
        product.setDescription(description);
        saveAvatar(avatar, product);

        productsDao.create(product);

        saveAllImages(files, product);

        return "redirect:/admin/products/";
    }

    @RequestMapping(value= "/products/{id}", method = RequestMethod.POST)
    public String doEditProduct(@PathVariable Integer id,
                                     @RequestParam(required = false, value = "categoryId") Integer categoryId,
                                     @RequestParam(required = true, value = "name") String name,
                                     @RequestParam(required = true, value = "description") String description,
                                     @RequestParam(required = false, value = "file") CommonsMultipartFile avatar,
                                     @RequestParam(required = false, value = "files") CommonsMultipartFile[] files) {

        Product product = productsDao.read(id);

        product.setName(name);
        product.setDescription(description);

        if (categoryId != null) {
            product.setCategory_id(categoryId);
        }
        if (avatar != null) {
            saveAvatar(avatar, product);
        }
        if(files != null) {
            saveAllImages(files, product);
        }

        productsDao.update(product);

        return "redirect:/admin/products/";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable Integer id) {
        Product product = productsDao.read(id);

        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("categories", categoryDao.getAll());
        modelAndView.addObject("product", product);

        return modelAndView;
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteImage(@PathVariable Integer id) {

        Product product = null;

        if (id != null) {
            product = productsDao.read(id);
            if (product != null) {
                productsDao.delete(product);
            }
        }
    }

    private boolean validateImage(CommonsMultipartFile file){
        return !file.getOriginalFilename().equals("");
    }

    private void saveAllImages(CommonsMultipartFile[] files, Product product) {

        if (files != null && files.length > 0 && product.getId() > 0) {
            for (CommonsMultipartFile aFile : files){

                System.out.println("Saving file: " + aFile.getOriginalFilename());


                if (validateImage(aFile)) {
                    try {
                        String fileUri = getUniqueResourceIdentity(aFile, product);

                            aFile.transferTo(new File(PATH + fileUri));

                        Image image = new Image();
                        image.setTitle(aFile.getOriginalFilename());
                        image.setProduct_id(product.getId());
                        image.setUri(fileUri);

                        imagesDao.create(image);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void saveImage(CommonsMultipartFile avatar, Product product, boolean isAvatar){
        System.out.println("Saving file: " + avatar.getOriginalFilename());

        if (validateImage(avatar)) {
            try {
                String fileUri = getUniqueResourceIdentity(avatar, product);

                avatar.transferTo(new File(PATH + fileUri));

                Image image = new Image();
                image.setTitle(avatar.getOriginalFilename());
                image.setUri(fileUri);
                if(!isAvatar) {
                    image.setProduct_id(product.getId());
                }

                imagesDao.create(image);

                if(isAvatar) {
                    product.setImage(image);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveAvatar(CommonsMultipartFile avatar, Product product){
        saveImage(avatar, product, true);
    }

    private String getUniqueResourceIdentity(CommonsMultipartFile file, Product product) {
        return  MD5.getMD5(file.getOriginalFilename() +
                product.getName() +
                product.getId() +
                file.getSize()) + ".jpg";
    }
}
