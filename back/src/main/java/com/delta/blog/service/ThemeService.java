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
            throw new Exception("id not found");
    }

    public Theme getThemeByName(String name) throws Exception {
        Theme result = themeRepository.findByName(name);
        if (result!= null)
            return result;
        else
            throw new Exception("Cannot find by name " + name);
    }

    public Theme createTheme(Theme theme) throws Exception {
        if (themeRepository.existsThemeByName(theme.getName()))
            throw new Exception("probably already exists");
        return themeRepository.save(theme);
    }

    public void deleteTheme(int id) throws Exception {
        try {
            themeRepository.deleteById(id);
        } catch (final Exception e) {
            throw new Exception("Theme does not exist");
        }
    }
}
