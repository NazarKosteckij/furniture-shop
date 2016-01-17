package com.test.rest.models;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by Nazar on 16.01.2016.
 */
@Entity
@Table(name = "images")
public class Image implements BaseModel {
    @Column
    @GeneratedValue
    @Id
    private Integer id;

    @Column(name="uri")
    private String uri;

    @Column
    private String title;

    @Column(name = "product_id")
    private Integer product_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}
