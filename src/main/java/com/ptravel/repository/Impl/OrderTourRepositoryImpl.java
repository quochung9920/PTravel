package com.ptravel.repository.Impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptravel.pojos.TourOrder;
import com.ptravel.repository.OrderTourRepository;

@Repository
@Transactional
public class OrderTourRepositoryImpl implements OrderTourRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public TourOrder addOrderTour(TourOrder orderTour) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {

            session.save(orderTour);
            
            return orderTour;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            System.out.println("Error in adding tour");
        }
        return null;
    }

    @Override
    public List<TourOrder> getAllOrderTour(boolean active) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            List<TourOrder> list = session.createQuery("from TourOrder where active = :active", TourOrder.class).setParameter("active", active).getResultList();
            return list;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            System.out.println("Error in getting tour");
        }
        return null;
    }

    @Override
    public List<TourOrder> getAllOrderTourByUser(int userId, boolean active) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TourOrder> criteria = builder.createQuery(TourOrder.class);
            Root<TourOrder> root = criteria.from(TourOrder.class);
            Predicate condition = builder.equal(root.get("userId"), userId);
            Predicate condition2 = builder.equal(root.get("active"), active);
            criteria.select(root).where(builder.and(condition, condition2));
            List<TourOrder> list = session.createQuery(criteria).getResultList();
            return list;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            System.out.println("Error in getting tour");
        }

        return null;
    }

    @Override
    public List<TourOrder> getListOrderTour() {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            List<TourOrder> list = session.createQuery("from TourOrder", TourOrder.class).getResultList();
            return list;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            System.out.println("Error in getting tour");
        }
        return null;
    }

    @Override
    public TourOrder updateOrderTour(int orderId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            TourOrder tourOrder = session.get(TourOrder.class, orderId);
            tourOrder.setActive(true);
            session.update(tourOrder);
            return tourOrder;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            System.out.println("Error in updating tour");
        }
        return null;
    }

    
}
