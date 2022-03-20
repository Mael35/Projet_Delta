package com.delta.blog.controller;

import com.delta.blog.model.Theme;
import com.delta.blog.service.ThemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/public/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("")
    public Iterable<Theme> getThemes() {
        return themeService.getThemes();
    }
    
}
