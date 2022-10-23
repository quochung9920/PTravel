package com.ptravel.repository.Impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.ptravel.pojos.Comment;
import com.ptravel.repository.CommentRepository;

@Controller
@Transactional
public class CommentRepositoryImpl implements CommentRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Comment addComment(Comment comment) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(comment);
            return comment;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Comment> getCommentByIdTour(int tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
        Root root = query.from(Comment.class);
        Predicate predicate = builder.equal(root.get("tourId"), tourId);
        query.select(root).where(predicate);
        Query<Comment> q = session.createQuery(query);
        return q.getResultList();
    }
    
}
