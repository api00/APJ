package com.domain;

import java.time.LocalDate;

public class User {


    private String name;
    private String Designation;
    private String gender;
    private int GSal;

    private int BSal;
    private int h_rent;
    private int CAllowance;
    private int MAllowance;
    private int others;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public int getGSal() {
        return GSal;
    }

    public void setGSal(int GSal) {
        this.GSal = GSal;
    }

    public int getBSal() {
        return BSal;
    }

    public void setBSal(int BSal) {
        this.BSal = BSal;
    }

    public int getH_rent() {
        return h_rent;
    }

    public void setH_rent(int h_rent) {
        this.h_rent = h_rent;
    }

    public int getCAllowance() {
        return CAllowance;
    }

    public void setCAllowance(int CAllowance) {
        this.CAllowance = CAllowance;
    }

    public int getMAllowance() {
        return MAllowance;
    }

    public void setMAllowance(int MAllowance) {
        this.MAllowance = MAllowance;
    }

    public int getOthers() {
        return others;
    }

    public void setOthers(int others) {
        this.others = others;
    }


}
