package com.sample.server.model;

import java.util.Date;

public class Element {

    private String id;
    private String name;
    private String description;

    private Date date;

    private boolean success;

    private int amount;

    public Element() {
    }

    public Element(String id, String name, String description, Date date, boolean success, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.success = success;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}