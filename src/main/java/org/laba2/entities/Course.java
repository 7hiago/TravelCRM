package org.laba2.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {

    @JsonAlias({"rate", "rateSell", "saleRate", "sale"})
    private float course;

    @JsonAlias({"cc", "currencyCodeA", "currency", "ccy"})
    private String currency;

    @JsonAlias({"exchangedate", "date"})
    private String date;

    private String bank;

    public Course() {
    }

    public float getCourse() {
        return course;
    }

    public void setCourse(float course) {
        this.course = course;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Course of " + currency + " in " + bank + " on " + date + " is " + course;
    }
}