package com.service;

import com.domain.TaxCal;
import com.domain.TaxUser;
import com.repository.TaxApplicationRepo;
import com.repository.TaxCalRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaxCalculation {
    private TaxCalRepo taxCalRepo;

    public TaxCalculation(TaxCalRepo taxCalRepo) {
        this.taxCalRepo = taxCalRepo;
    }

    @Transactional
    public void insert(TaxCal tax) {
         taxCalRepo.create(tax);

    }
}
