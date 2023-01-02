package com.service;

import com.domain.taxLiability;

import java.util.List;

public interface TaxLiability {

    public taxLiability insert(taxLiability taxLiability);

    public taxLiability get(Long id);

    public List<taxLiability> getAll();

    public taxLiability update(taxLiability taxLiability);

    public void delete(Long id);
}
