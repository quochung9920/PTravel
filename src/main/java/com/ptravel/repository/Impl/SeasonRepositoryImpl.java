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

import com.ptravel.pojos.Season;
import com.ptravel.repository.SeasonRepository;

@Repository
@Transactional
public class SeasonRepositoryImpl implements SeasonRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Season> getListSeason() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Season> query = builder.createQuery(Season.class);
        Root<Season> root = query.from(Season.class);
        query = query.select(root);
        Query<Season> q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Season getSeasonById(Integer seasonId) {
        return sessionFactory.getObject().getCurrentSession().get(Season.class, seasonId);
    }

}
