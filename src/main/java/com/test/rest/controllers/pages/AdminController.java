package com.test.rest.controllers.pages;

import com.test.rest.dao.CategoryDao;
import com.test.rest.dao.ImagesDao;
import com.test.rest.dao.ProductDao;
import com.test.rest.models.Category;
import com.test.rest.models.Image;
import com.test.rest.models.Product;
import com.test.rest.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Nazar on 16.01.2016.
 */
@Controller
@RequestMapping(value = "")
public class AdminController {
    @RequestMapping("/admin")
    public String get(){
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
