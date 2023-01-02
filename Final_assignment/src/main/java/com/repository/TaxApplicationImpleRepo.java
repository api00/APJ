package com.repository;

import com.domain.TaxUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxApplicationImpleRepo implements TaxApplicationRepo {

    private SessionFactory sessionFactory;

    public TaxApplicationImpleRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<TaxUser> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<TaxUser> user = session.createQuery("from TaxUser", TaxUser.class);
       return user.getResultList();
    }

    public TaxUser create(TaxUser user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

        return user;
    }

    public TaxUser get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TaxUser.class, id);
    }

    public TaxUser update(TaxUser user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        TaxUser user = get(id);
        if (user != null) {
            session.delete(user);
        }
    }
}
