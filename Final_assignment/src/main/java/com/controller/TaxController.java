package com.controller;

import com.domain.Calculations;
import com.domain.LiabilityCalculation;
import com.domain.TaxCal;
import com.domain.TaxUser;


import com.service.TaxCalculation;
import com.service.TaxService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/tax")
public class TaxController {


    private TaxService taxService;
    private TaxCalculation taxCalculation;


    public  TaxController(TaxService taxService, TaxCalculation taxCalculation){

        this.taxService = taxService;
        this.taxCalculation = taxCalculation;
    }


    @PostMapping(path = "/add")
    public int add(@Valid @RequestBody TaxUser user) {
        System.out.println(user.getC_allowence());
       Calculations cal = new Calculations() ;;
          TaxCal tax = new TaxCal();
        tax.setH_rent(cal.HouseRent(user));
        tax.setB_sal(cal.BasicSal(user));
        tax.setM_allowence(cal.MedicalAllownce(user));
        tax.setC_allowence(cal.ConveyCAllownce(user));
        tax.setTotal(cal.Total(user));
        tax.setOthers(cal.other(user));
        tax.setU_id(user.getU_id());

        taxCalculation.insert(tax);

        taxService.insert(user);
        LiabilityCalculation tx = new LiabilityCalculation();
        ArrayList<Integer> value =tx.Tax(user);
        int result =0;
        for(int i=0;i< value.size();i++){
            result = result + value.get(i);
        }
        int MTPaybale = result/12;

        return MTPaybale;






    }
    @RequestMapping("/welcome")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String greet() {
        return  "Welcome to E-TAX Calculation System";
    }


}
