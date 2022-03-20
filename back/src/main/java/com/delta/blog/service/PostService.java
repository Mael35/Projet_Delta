package com.delta.blog.service;

import java.util.Optional;

import com.delta.blog.model.Post;
import com.delta.blog.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(int id) throws Exception {
        Optional<Post> result = postRepository.findById(id);
        if (result.isPresent())
            return result.get();
        else
            throw new Exception();
    }
    
}
