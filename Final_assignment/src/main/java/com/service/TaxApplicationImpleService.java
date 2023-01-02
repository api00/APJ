package com.service;

import com.domain.TaxUser;
import com.repository.TaxApplicationRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaxApplicationImpleService implements TaxService {
    private TaxApplicationRepo taxApplicationRepo;


    public TaxApplicationImpleService(TaxApplicationRepo taxApplicationRepo) {
        this.taxApplicationRepo = taxApplicationRepo;
    }

    @Transactional
    public TaxUser insert(TaxUser user) {
         taxApplicationRepo.create(user);
        return user;
    }

    @Transactional(readOnly = true)
    public TaxUser get(Long id) {
        return taxApplicationRepo.get(id);
    }

    @Transactional(readOnly = true)
    public List<TaxUser> getAll() {
       return taxApplicationRepo.getAll();
    }

    @Transactional
    public TaxUser update(TaxUser user) {
        return taxApplicationRepo.update(user);
    }

    @Transactional
    public void delete(Long id) {
        taxApplicationRepo.delete(id);
    }
}
