package com.codegym.model;

import javax.persistence.*;

@Entity
@Table (name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String feedback;
    private int likeVote;

    public Comment() {
    }

    public Comment(Long id, String author, String feedback, int likeVote) {
        this.id = id;
        this.author = author;
        this.feedback = feedback;
        this.likeVote = likeVote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLikeVote() {
        return likeVote;
    }

    public void setLikeVote(int likeVote) {
        this.likeVote = likeVote;
    }
}
