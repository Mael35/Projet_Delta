package com.delta.blog.model;

import javax.persistence.Entity;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "posts")
public class Post {

    @Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String title;
    private String author;
    private String content;

    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { 
            CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "posts_themes", joinColumns = {
            @JoinColumn(name = "posts_id") }, 
                inverseJoinColumns = { @JoinColumn(name = "theme_id") })
    private List<Theme> listOfThemes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return created_at;
    }

    public void setDate(Date date) {
        this.created_at = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Theme> getThemes() {
        return listOfThemes;
    }

    public void setThemes(List<Theme> themes) {
        this.listOfThemes = themes;
    }
    
}
