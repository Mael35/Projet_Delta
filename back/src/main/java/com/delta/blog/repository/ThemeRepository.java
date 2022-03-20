package com.delta.blog.repository;

import com.delta.blog.model.Theme;

import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Integer> {

    public Theme findByName(String name);

    public boolean existsThemeByName(String name);
    
}
