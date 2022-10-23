package com.ptravel.repository.Impl;

import java.nio.file.Path;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptravel.pojos.User;
import com.ptravel.repository.UserRepository;


@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try{
            session.save(user);
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }

        return false;
    }


    @Override
    public List<User> getUsers(String email) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        if(!email.isEmpty()){
            Predicate p = builder.equal(root.get("email").as(String.class), email.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);

        return q.getResultList();
    }


    @Override
    public List<User> getListUsers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        Predicate p = builder.notLike(root.get("userRole").as(String.class), User.ADMIN);
        query = query.where(p);
        Query q = session.createQuery(query);
        return q.getResultList();

    }


    @Override
    public User updateUser(User user, int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("id").as(Integer.class), userId);
        query = query.where(p);
        Query q = session.createQuery(query);
        User u = (User) q.getSingleResult();

        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setPhone(user.getPhone());
        u.setConfirmPassword(user.getPhone());

        try{
            session.update(u);
            return u;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return null;
    }


    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        Predicate p2 = builder.equal(root.get("id").as(Integer.class), id);
        query = query.where(p2);
        Query q = session.createQuery(query);
        return (User) q.getSingleResult();
    }


    @Override
    public boolean updateAvatar(int userId, String avatar) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("id").as(Integer.class), userId);
        query = query.where(p);
        Query q = session.createQuery(query);
        User u = (User) q.getSingleResult();

        u.setAvatar(avatar);
        u.setPassword(u.getPassword());
        u.setConfirmPassword(u.getPassword());

        try{
            session.update(u);
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;

        
    }




}
