package com.test.rest.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nazar on 16.01.2016.
 */
@Entity
@Table(name = "categories")
public class Category implements BaseModel {
    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category_id", fetch = FetchType.EAGER)
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}