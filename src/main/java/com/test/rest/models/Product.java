package com.test.rest.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Nazar on 16.01.2016.
 */
@Entity
@Table(name = "products")
public class Product  implements BaseModel{

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne
    private Image image;


    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Column
    private Integer category_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
