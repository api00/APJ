package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "tax_cal")
public class TaxCal {

    @Id
    private Integer u_id;
    @Column(name = "b_sal")
    private Integer b_sal;
    @Column(name = "h_rent")
    private Integer h_rent;
    @Column(name = "c_allowence")
    private Integer c_allowence;
    @Column(name = "m_allowence")
    private Integer m_allowence;

    @Column(name = "others")
    private Integer others;

    @Column(name = "total")
    private Integer total;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public Integer getB_sal() {
        return b_sal;
    }

    public void setB_sal(int b_sal) {
        this.b_sal = b_sal;
    }

    public Integer getH_rent() {
        return h_rent;
    }

    public void setH_rent(int h_rent) {
        this.h_rent = h_rent;
    }

    public Integer getC_allowence() {
        return c_allowence;
    }

    public void setC_allowence(int c_allowence) {
        this.c_allowence = c_allowence;
    }

    public Integer getM_allowence() {
        return m_allowence;
    }

    public void setM_allowence(int m_allowence) {
        this.m_allowence = m_allowence;
    }

    public Integer getOthers() {
        return others;
    }

    public void setOthers(int others) {
        this.others = others;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
