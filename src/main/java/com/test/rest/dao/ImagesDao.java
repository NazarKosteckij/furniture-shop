package com.test.rest.dao;

import com.test.rest.models.Image;

import java.util.List;

/**
 * Created by Nazar on 16.01.2016.
 */
public interface ImagesDao extends Dao<Image> {
    List<Image> getByProductId(Integer id);
}
