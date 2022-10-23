package com.ptravel.repository.Impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.ptravel.pojos.Region;
import com.ptravel.repository.RegionRepository;

@Repository
@Transactional
public class RegionRepositoryImpl implements RegionRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Region> getListRegion() {
       
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Region> query = builder.createQuery(Region.class);
        Root<Region> root = query.from(Region.class);
        query = query.select(root);
        Query<Region> q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Region getRegionById(Integer regionId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Region.class, regionId);
    }

    
}
