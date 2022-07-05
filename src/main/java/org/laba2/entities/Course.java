package org.laba2.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course1 = (Course) o;
        return Float.compare(course1.getCourse(), getCourse()) == 0 && getCurrency().equals(course1.getCurrency()) && getDate().equals(course1.getDate()) && getBank().equals(course1.getBank());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getCurrency(), getDate(), getBank());
    }

    @Override
    public String toString() {
        return "Course of " + currency + " in " + bank + " on " + date + " is " + course;
    }
}