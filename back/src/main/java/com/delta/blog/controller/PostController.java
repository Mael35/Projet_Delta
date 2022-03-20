package com.delta.blog.controller;

import com.delta.blog.model.Post;
import com.delta.blog.model.Theme;
import com.delta.blog.service.PostService;
import com.delta.blog.service.ThemeService;
import com.delta.blog.service.PostService._Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/public/post")
public class PostController {

    @Autowired
    private PostService postService;
    private ThemeService themeService;

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
            return new ResponseEntity<String>("Post not found", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("")
    public ResponseEntity createPost(@RequestBody _Post post) throws Exception {
        try {
            Post newPost = postService.createPost(post);
            return new ResponseEntity<Post>(newPost, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity deleteArticle(@PathVariable("post_id") int id) {
        try {
            postService.deletePost(id);
            return new ResponseEntity<Post>(HttpStatus.OK);
        } catch (final Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.NOT_FOUND);
        }
    }

}
