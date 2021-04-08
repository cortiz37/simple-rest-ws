package com.sample.server.model;

import java.util.Date;

public class ElementV2 {

    private String id;
    private String index;

    private Date date;

    private Double total;

    public ElementV2() {
    }

    public ElementV2(String id, String index, Date date, Double total) {
        this.id = id;
        this.index = index;
        this.date = date;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}