package com.TaxCal;

import com.domain.User;

import javax.validation.Valid;

public class TaxCal {
    @Valid User user;
    public int BasicSal(@Valid User user){
        int BasicSal = 12* user.getBSal();
        return  BasicSal;
    }
    public int HouseRent(@Valid User user) {
        int yearlyHouseRent = 12 * user.getH_rent();
        int BasicSal = 12 * user.getBSal();
        int HalfOfBaisicSal = BasicSal / 2;
        int HouseRent = yearlyHouseRent - HalfOfBaisicSal;
        if (HouseRent > 300000) {
            HouseRent = 300000;
        }
        return HouseRent;
    }
    public int ConveyCAllownce(@Valid User user){
        int ConveyCAllownce = 12* user.getCAllowance();
        int cAll = ConveyCAllownce - 30000;

        return cAll;

    }
    public  int MedicalAllownce(@Valid User user){
        int MedicalAllownce = 12* user.getMAllowance();

        return  MedicalAllownce;

    }
    public int other(@Valid User user) {
        int others = 12 * user.getOthers();
        return others;
    }

    public int Total (@Valid User user){
        int total = other(user)+MedicalAllownce(user)+ConveyCAllownce(user)+HouseRent(user)+BasicSal(user);
        return  total;
    }





}
