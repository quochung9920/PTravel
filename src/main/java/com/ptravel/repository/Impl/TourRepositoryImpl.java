package com.ptravel.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ptravel.pojos.TourDetail;
import com.ptravel.pojos.TourOrder;
import com.ptravel.repository.TourRepository;

@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class TourRepositoryImpl implements TourRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    
    @Override
    public TourDetail addTour(TourDetail tour) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(tour);
            return tour;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            System.out.println("Error in adding tour");
        }
        
        return null;
    }

    @Override
    public List<TourDetail> getTours(int page, int size) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<TourDetail> q = b.createQuery(TourDetail.class);
        Root root = q.from(TourDetail.class);
        q = q.select(root);

        Query<TourDetail> query = session.createQuery(q);
        if (page > 0) {
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

    @Override
    public TourDetail getTourById(Integer tourId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        return session.get(TourDetail.class, tourId);
    }

    @Override
    public boolean updateTour(TourDetail tour, Integer tourId) {
        
        try {
            Session session = sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<TourDetail> q = b.createQuery(TourDetail.class);
            Root root = q.from(TourDetail.class);
            q = q.select(root);
            q = q.where(b.equal(root.get("id"), tourId));
            Query<TourDetail> query = session.createQuery(q);
            TourDetail tourDetail = query.getSingleResult();
            tourDetail.setHeader(tour.getHeader());
            tourDetail.setIntro(tour.getIntro());
            tourDetail.setSchedule(tour.getSchedule());
            tourDetail.setPriceAdult(tour.getPriceAdult());
            tourDetail.setPriceChild(tour.getPriceChild());
            tourDetail.setTourName(tour.getTourName());
            tourDetail.setSeasonId(tour.getSeasonId());
            tourDetail.setRegionId(tour.getRegionId());
            session.update(tourDetail);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean deleteTour(Integer tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            TourDetail tourDetail = session.get(TourDetail.class, tourId);
            session.delete(tourDetail);
            return true;
        } catch (Exception e) {
            System.err.println("== DELETE PRODUCT FAILED ==" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateTourImages(TourDetail tourDetail, Integer tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TourDetail> query = builder.createQuery(TourDetail.class);
        Root root = query.from(TourDetail.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("id").as(Integer.class), tourId);
        query = query.where(p);
        Query q = session.createQuery(query);
        TourDetail t = (TourDetail) q.getSingleResult();
        try{
            session.update(t);
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;

    }

    @Override
    public int countTours() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<TourDetail> q = b.createQuery(TourDetail.class);
        Root root = q.from(TourDetail.class);
        q = q.select(root);
        Query<TourDetail> query = session.createQuery(q);
        return query.getResultList().size();
    }

    @Override
    public List<TourDetail> getToursBySeason(int seasonId, int size) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<TourDetail> q = b.createQuery(TourDetail.class);
        Root root = q.from(TourDetail.class);
        q = q.select(root);
        q = q.where(b.equal(root.get("seasonId"), seasonId));
        Query<TourDetail> query = session.createQuery(q);
        if (size > 0) {
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

    @Override
    public boolean activeOrderTour(int orderId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<TourOrder> q = b.createQuery(TourOrder.class);
        Root root = q.from(TourOrder.class);
        q = q.select(root);
        q = q.where(b.equal(root.get("id"), orderId));
        Query<TourOrder> query = session.createQuery(q);
        TourOrder orderTour = query.getSingleResult();
        orderTour.setActive(true);
        try {
            session.update(orderTour);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateTourImages(int tourId, String imageList) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<TourDetail> q = b.createQuery(TourDetail.class);
        Root root = q.from(TourDetail.class);
        q = q.select(root);
        q = q.where(b.equal(root.get("id"), tourId));
        Query<TourDetail> query = session.createQuery(q);
        TourDetail tourDetail = query.getSingleResult();
        tourDetail.setImage(imageList);
        try {
            session.update(tourDetail);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<TourDetail> getTours(Map<String, String> params) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<TourDetail> q = b.createQuery(TourDetail.class);
        Root root = q.from(TourDetail.class);
        q = q.select(root);

        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("tourName").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            // String fp = params.get("priceAdult");
            // if (fp != null) {
            //     Predicate p = b.greaterThanOrEqualTo(root.get("priceAdult").as(Long.class), Long.parseLong(fp));
            //     predicates.add(p);
            // }

            q.where(predicates.toArray(new Predicate[]{}));
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
}
