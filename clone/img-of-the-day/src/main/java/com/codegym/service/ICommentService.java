package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(Long id);
    void save(Comment comment);
    void remove(Long id);
    int like(Long id);
}
