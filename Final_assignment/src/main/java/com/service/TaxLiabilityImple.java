package com.service;

import com.domain.TaxUser;
import com.domain.taxLiability;
import com.repository.TaxApplicationRepo;
import com.repository.TaxLiabilityRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaxLiabilityImple implements TaxLiability {
    private TaxLiabilityRepo taxLiabilityRepo;


    public TaxLiabilityImple(TaxLiabilityRepo taxLiabilityRepo) {
        this.taxLiabilityRepo = taxLiabilityRepo;
    }

    @Transactional
    public taxLiability insert(taxLiability user) {
        taxLiabilityRepo.create(user);
        return user;
    }

    @Transactional(readOnly = true)
    public taxLiability get(Long id) {
        return taxLiabilityRepo.get(id);
    }

    @Transactional(readOnly = true)
    public List<taxLiability> getAll() {
        return taxLiabilityRepo.getAll();
    }

    @Transactional
    public taxLiability update(taxLiability user) {
        return taxLiabilityRepo.update(user);
    }

    @Transactional
    public void delete(Long id) {
        taxLiabilityRepo.delete(id);
    }
}
