package com.test.rest.controllers;

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
 * Created by Nazar on 16.01.2016.
 */
@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImagesDao imagesDao;

    private static final String path = "D:/img/";

    @RequestMapping(value = "/")
    public String home(){
        return "Image";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("document") Image document,
            @RequestParam("file") CommonsMultipartFile[] file) {

/*

        System.out.println("File:" + file.getName());
        System.out.println("ContentType:" + file.getContentType());

        try {
            Blob blob = Hibernate.createBlob(file.getInputStream());

            document.setTitle(file.getOriginalFilename());
            document.setContent(blob); ;
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            imagesDao.create(document);
        } catch(Exception e) {
            e.printStackTrace();
        }
*/

        if (file != null && file.length > 0) {
            for (CommonsMultipartFile aFile : file){

                System.out.println("Saving file: " + aFile.getOriginalFilename());


                if (!aFile.getOriginalFilename().equals("")) {
                    try {
                        aFile.transferTo(new File(path + MD5.getMD5(aFile.getOriginalFilename())));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    return "home";
    }
}
