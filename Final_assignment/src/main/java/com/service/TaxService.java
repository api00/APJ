package com.service;

import com.domain.TaxUser;

import java.util.List;

public interface TaxService {

    public TaxUser insert(TaxUser user);

    public TaxUser get(Long id);

    public List<TaxUser> getAll();

    public TaxUser update(TaxUser user);

    public void delete(Long id);
}
