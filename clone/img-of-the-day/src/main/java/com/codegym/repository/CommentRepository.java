package com.codegym.repository;

import com.codegym.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentRepository implements ICommentRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = entityManager.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        TypedQuery<Comment> query = entityManager.createQuery("select c from Comment c where c.id = :id", Comment.class);
        query.setParameter("id", id);
        Comment comment;
        try {
            comment = query.getSingleResult();
        } catch (NoResultException e) {
            comment = null;
        }
        return comment;

    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() != null) {
            entityManager.merge(comment);
        } else {
            entityManager.persist(comment);
        }
    }

    @Override
    public void remove(Long id) {
        Comment comment = findById(id);
        if (comment != null) {
            entityManager.remove(comment);
        }
    }

    @Override
    public int like(Long id) {
        Comment comment = findById(id);
        comment.setLikeVote(comment.getLikeVote() + 1);
        entityManager.merge(comment);
        return comment.getLikeVote();
    }
}
