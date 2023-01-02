package com.repository;

import com.domain.TaxCal;
import com.domain.TaxUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TaxCalRepo {

    private SessionFactory sessionFactory;

    public TaxCalRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void create(TaxCal user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

    }
}
