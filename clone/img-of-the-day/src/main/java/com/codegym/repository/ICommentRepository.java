package com.codegym.repository;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAll();
    Comment findById(Long id);
    void save(Comment comment);
    void remove(Long id);
    int like(Long id);
}
