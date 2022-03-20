package com.delta.blog.service;

import java.util.Date;
import java.util.Optional;

import com.delta.blog.model.Post;
import com.delta.blog.model.Theme;
import com.delta.blog.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ThemeService themeService;

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

    public static class _Post {
        public int theme_id;
        public String title;
        public String author;
        public String content;
    }

    public Post createPost(_Post _post) throws Exception {
        Post post = new Post();
        try {
            Theme theme = themeService.getTheme(_post.theme_id);
            post.setTheme(theme);
        } catch (final Exception e) {
            throw new Exception(e);
        }
        post.setTitle(_post.title);
        post.setAuthor(_post.author);
        post.setContent(_post.content);
        post.setDate(new Date());
        return postRepository.save(post);
    }

    public void deletePost(int id) throws Exception {
        try {
            postRepository.deleteById(id);
        } catch (final Exception e) {
            throw new Exception(e);
        }
    }
    
}
