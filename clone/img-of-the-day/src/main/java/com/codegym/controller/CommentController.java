package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("")
    public ModelAndView index() {
        List<Comment> comments = commentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(Comment comment) {
        commentService.save(comment);
        List<Comment> comments = commentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("message", "Add comment successfully");
        return modelAndView;

    }

    @PostMapping("/{id}/like")
    public ModelAndView like(@PathVariable("id") Long id,  RedirectAttributes redirect) {
        commentService.like(id);
        return index();
    }
}
