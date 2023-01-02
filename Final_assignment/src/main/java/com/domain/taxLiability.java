package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "tax_liability")
public class taxLiability {

    @Id
    private Integer id;
    @Column(name = "particulars")
    private Integer particulars;
    @Column(name = "rate")
    private Integer rate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParticulars() {
        return particulars;
    }

    public void setParticulars(Integer particulars) {
        this.particulars = particulars;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
