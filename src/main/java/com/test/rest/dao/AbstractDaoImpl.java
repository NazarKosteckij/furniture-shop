package com.test.rest.dao;

import com.test.rest.models.BaseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Nazar on 09.01.2016.
 */
public abstract class AbstractDaoImpl<T extends BaseModel> extends HibernateDaoSupport implements Dao<T> {
    private final Class<T> clazz;

    protected AbstractDaoImpl() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<T> getAll(){
        Session session = getSession();
        session.beginTransaction();

        List<T> list = session.createQuery("from " + this.clazz + "  request").list();

        closeSession(session);
        return  list;
    }

    public  T read(Integer id){
        Session session = getSession();
        session.beginTransaction();

        T obj = (T) session.get(clazz, id);

        closeSession(session);
        return  obj;
    }

    public void create(T o) {
        Session session = getSession();
        session.beginTransaction();
        session.save(o);

        closeSession(session);
    }

    @Override
    public void update(T o) {
        Session session = getSession();
        session.beginTransaction();
        session.update(o);

        closeSession(session);
    }

    @Override
    public void delete(T o) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(o);

        closeSession(session);
    }

    protected final void closeSession(Session session){
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
