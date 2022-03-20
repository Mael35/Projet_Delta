package com.delta.blog.model;

import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "themes")
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

    public void addArticle(Post post) {
        this.listOfposts.add(post);
        post.getThemes().add(this);
    }

    public void removeArticle(Post post) {
        this.listOfposts.remove(post);
        post.getThemes().remove(this);
    }
    
}
