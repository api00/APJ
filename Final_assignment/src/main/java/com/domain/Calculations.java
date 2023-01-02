package com.domain;

import com.domain.TaxCal;
import com.domain.TaxUser;


import javax.validation.Valid;

public class Calculations {
    @Valid TaxUser user;

    public int BasicSal(@Valid TaxUser user){
        int BasicSal = 12* user.getB_sal();
       /* TaxCal cal = new TaxCal();
           cal.setB_sal(BasicSal);
         int bsal = cal.getB_sal();*/

        return  BasicSal;
    }
    public int HouseRent(@Valid TaxUser user) {

        int yearlyHouseRent = 12 * user.getH_rent();
        int BasicSal = 12 * user.getB_sal();
        int HalfOfBaisicSal = BasicSal / 2;
        int HouseRent = yearlyHouseRent - HalfOfBaisicSal;
        if (HouseRent > 300000) {
            HouseRent = 300000;
        }
      /*  TaxCal cal = new TaxCal();
        cal.setH_rent(HouseRent);*/
        return HouseRent;
    }
    public int ConveyCAllownce(@Valid TaxUser user){

        int ConveyCAllownce = 12* user.getC_allowence();
        int cAll = ConveyCAllownce - 30000;
       /* TaxCal cal = new TaxCal();

        cal.setC_allowence(cAll);*/
        return cAll;

    }
    public  int MedicalAllownce(@Valid TaxUser user){
        int MedicalAllownce = 12* user.getM_allowence();
       /* TaxCal cal = new TaxCal();
        cal.setM_allowence(MedicalAllownce);*/
        return  MedicalAllownce;

    }
    public int other(@Valid TaxUser user) {
        int others = 12 * user.getOthers();
        /*TaxCal cal = new TaxCal();
        cal.setOthers(others);*/
        return others;
    }

    public int Total (@Valid TaxUser user){
        int total = other(user)+MedicalAllownce(user)+ConveyCAllownce(user)+HouseRent(user)+BasicSal(user);
     /*   TaxCal cal = new TaxCal();
        cal.setTotal(total);*/
        return  total;
    }





}