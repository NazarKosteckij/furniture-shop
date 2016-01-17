package com.test.rest.dao;

import com.test.rest.models.Product;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nazar on 16.01.2016.
 */
public class ProductDaoImpl extends AbstractDaoImpl<Product> implements ProductDao {
    @Override
    public List<Product> getAll() {
        Session session = getSession();
        session.beginTransaction();

        List<Product> products = session.createQuery("from com.test.rest.models.Product  request").list();

        closeSession(session);
        return  products;
    }

    @Override
    public Product read(Integer id) {
        Session session = getSession();
        session.beginTransaction();

        Product product =(Product) session.get(Product.class, id);

        closeSession(session);
        return product;
    }
}
