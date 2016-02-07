package com.test.rest.dao;

import com.test.rest.models.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nazar on 16.01.2016.
 */
public class ImagesDaoImpl extends AbstractDaoImpl<Image> implements ImagesDao{

    @Override
    public List<Image> getByProductId(Integer id) {
       Session session = getSession();
        session.beginTransaction();
        List<Image>  images = session.createQuery("FROM  com.test.rest.models.Image image WHERE image.product_id = :id")
                .setInteger("id", id).list();
        return images;
    }
}
