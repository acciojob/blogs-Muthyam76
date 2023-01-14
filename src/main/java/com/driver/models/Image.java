package com.driver.models;

import javax.persistence.*;

@Entity
public class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String dimensions;

    public Image(String description,String dimensions,int id) {
        this.description = description;
        this.dimensions=dimensions;
        this.id=id;
    }

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @ManyToOne
    @JoinColumn
    private Blog blog;
}