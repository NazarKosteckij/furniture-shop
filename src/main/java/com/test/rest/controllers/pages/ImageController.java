package com.test.rest.controllers.pages;

import com.test.rest.dao.ImagesDao;
import com.test.rest.models.Image;
import com.test.rest.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Nazar on 17.01.2016.
 */
@Controller
@RequestMapping("admin/images")
public class ImageController {

    @Autowired
    ImagesDao imagesDao;

    private static final String path = "D:/img/";

    @RequestMapping(value = "/")
    public String home(){
        return "Image";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("document") Image document,
            @RequestParam("file") CommonsMultipartFile[] file) {

        return "home";
    }
}
