package com.delta.blog.controller;

import com.delta.blog.model.Theme;
import com.delta.blog.service.ThemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping("/{theme_id}")
    public ResponseEntity getTheme(@PathVariable("theme_id") int id) {
        try {
            final Theme theme = themeService.getTheme(id);
            return new ResponseEntity<Theme>(theme, HttpStatus.OK);
        } catch (final Exception e) {
            return new ResponseEntity<String>("Theme not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Theme> addTheme(@RequestBody Theme theme) {
        try {
            Theme result = themeService.createTheme(theme);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{theme_id}")
    public ResponseEntity deleteCategory(@PathVariable("theme_id") int id) {
        try {
            themeService.deleteTheme(id);
            return new ResponseEntity<Theme>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Theme not found", HttpStatus.NOT_FOUND);
        }
    }
    
}
