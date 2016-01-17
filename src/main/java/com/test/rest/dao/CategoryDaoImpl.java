package com.test.rest.dao;

import com.test.rest.models.Category;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nazar on 16.01.2016.
 */
public class CategoryDaoImpl extends AbstractDaoImpl<Category> implements CategoryDao {
    @Override
    public List<Category> getAll() {
        Session session = getSession();
        session.beginTransaction();

        List<Category> categories = session.createQuery("from com.test.rest.models.Category  request").list();

        closeSession(session);
        return  categories;
    }

    @Override
    public Category read(Integer id) {
        Session session = getSession();
        session.beginTransaction();

        Category category = (Category) session.get(Category.class, id);

        closeSession(session);
        return  category;
    }
}
