package com.delta.blog.repository;

import com.delta.blog.model.Theme;

import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Integer> {

    public Iterable<Theme> findByName(String name);
    
}
