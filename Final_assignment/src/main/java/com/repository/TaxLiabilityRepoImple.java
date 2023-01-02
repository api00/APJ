package com.repository;

import com.domain.TaxUser;
import com.domain.taxLiability;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxLiabilityRepoImple implements TaxLiabilityRepo {

    private SessionFactory sessionFactory;

    public TaxLiabilityRepoImple(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<taxLiability> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<taxLiability> user = session.createQuery("from taxLiability", taxLiability.class);
        return user.getResultList();
    }

    public taxLiability create(taxLiability user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

        return user;
    }

    public taxLiability get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(taxLiability.class, id);
    }

    public taxLiability update(taxLiability user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        taxLiability user = get(id);
        if (user != null) {
            session.delete(user);
        }
    }
}
