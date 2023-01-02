package com.repository;

import com.domain.TaxUser;

import java.util.List;

public interface TaxApplicationRepo {

    public List<TaxUser> getAll();

    public TaxUser create(TaxUser user);

    public TaxUser get(Long id);

    public TaxUser update(TaxUser user);

    public void delete(Long id);
}
