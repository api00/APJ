package com.repository;

import com.domain.TaxUser;
import com.domain.taxLiability;

import java.util.List;

public interface TaxLiabilityRepo {

    public List<taxLiability> getAll();

    public taxLiability create(taxLiability user);

    public taxLiability get(Long id);

    public taxLiability update(taxLiability user);

    public void delete(Long id);
}
