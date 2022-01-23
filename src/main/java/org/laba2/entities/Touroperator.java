package org.laba2.entities;

import java.util.Objects;

public class Touroperator {
    private int touroperatorId;
    private String name;
    private String phoneNumber;
    private String email;

    public Touroperator() {}

    public Touroperator(int touroperatorId, String name, String phoneNumber, String email) {
        this.touroperatorId = touroperatorId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getTouroperatorId() {
        return touroperatorId;
    }

    public void setTouroperatorId(int touroperatorId) {
        this.touroperatorId = touroperatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Touroperator that = (Touroperator) o;
        return getTouroperatorId() == that.getTouroperatorId() && getName().equals(that.getName()) && getPhoneNumber().equals(that.getPhoneNumber()) && getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTouroperatorId(), getName(), getPhoneNumber(), getEmail());
    }
}
