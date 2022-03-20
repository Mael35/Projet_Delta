package com.delta.blog.service;

import java.util.Optional;

import com.delta.blog.model.Theme;
import com.delta.blog.repository.ThemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public Iterable<Theme> getThemes() {
        return themeRepository.findAll();
    }
    
    public Theme getTheme(int id) throws Exception {
        Optional<Theme> result = themeRepository.findById(id);
        if (result.isPresent())
            return result.get();
        else
            throw new Exception();
    }
}