package com.delta.blog.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = com.delta.blog.model.Post.class , cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, mappedBy = "theme")
    private List<Post> listOfposts = new ArrayList<>();

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

    public List<Post> getArticles() {
        return listOfposts;
    }

    public void setArticles(List<Post> posts) {
        this.listOfposts = posts;
    }
    
}
