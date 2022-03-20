package com.delta.blog.controller;

import com.delta.blog.model.Post;
import com.delta.blog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/public/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public Iterable<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{post_id}")
    public ResponseEntity getPost(@PathVariable("post_id") int id) {
        try {
            final Post Post = postService.getPost(id);
            return new ResponseEntity<Post>(Post, HttpStatus.OK);
        } catch (final Exception e) {
            return new ResponseEntity<String>("Article not found", HttpStatus.NOT_FOUND);
        }
    }
    
}
