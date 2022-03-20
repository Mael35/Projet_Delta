package com.delta.blog.repository;

import com.delta.blog.model.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {

    public Iterable<Post> findByTitleIgnoreCaseContaining(String title);

    public Iterable<Post> findByContentIgnoreCaseContaining(String content);

    public Iterable<Post> findByAuthorIgnoreCaseContaining(String author);
}
