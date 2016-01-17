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

    @Column(name="content")
    @Lob
    private Blob content;

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

    public Integer getCategory_id() {
        return product_id;
    }

    public void setCategory_id(Integer category_id) {
        this.product_id = category_id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }
}
