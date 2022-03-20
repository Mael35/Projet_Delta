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
	@Column( name = "id" )
    private Integer id;

    @Column( name = "title")
    private String title;

    @Column( name = "author")
    private String author;

    @Column( name = "content")
    private String content;

    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
    @JoinTable(name = "posts_themes", joinColumns = { @JoinColumn(name = "posts_id") }, inverseJoinColumns = { @JoinColumn(name = "theme_id") })
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
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
