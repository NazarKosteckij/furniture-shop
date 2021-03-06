package com.test.rest.services;

import java.util.List;

/**
 * Created by Nazar on 20.12.2015.
 */
public interface CrudService<T> {
    /**
     * Gets all users from database
     * @return List of {@link T}
     */
    public List<T> getAll();

    /**
     * Creates entity {@link T} in database
     * @param obj
     */
    public void create(T obj);

    /**
     * Gets {@link T} by id
     * @param id
     * @return {@link T}
     */
    public T read(Integer id);

    /**
     * Updates {@link T}
     * @param obj
     */
    public void update(T obj);

    /**
     * Deletes {@link T}
     * @param obj
     */
    public void delete(T obj);

}
