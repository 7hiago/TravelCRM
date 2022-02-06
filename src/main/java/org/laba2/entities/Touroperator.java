package org.laba2.entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Touroperator {
    private String touroperatorId;

    @Size(min=2, max=50, message = "Entered name must contain at least 2 characters and a maximum of 30 characters")
    private String name;

    @Pattern(regexp = "^(\\+?[0-9]{3}|0)[0-9]{9}$", message = "Please enter a valid phone number")
    private String phoneNumber;

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid e-mail address")
    private String email;

    public Touroperator() {}

    public Touroperator(String touroperatorId, String name, String phoneNumber, String email) {
        this.touroperatorId = touroperatorId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getTouroperatorId() {
        return touroperatorId;
    }

    public void setTouroperatorId(String touroperatorId) {
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
        return getTouroperatorId().equals(that.getTouroperatorId()) && getName().equals(that.getName()) && getPhoneNumber().equals(that.getPhoneNumber()) && getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTouroperatorId(), getName(), getPhoneNumber(), getEmail());
    }
}
