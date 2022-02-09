package org.laba2.entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Customer {
    private String customerId;

    @Size(min=2, max=50, message = "Entered first name must contain at least 2 characters and a maximum of 30 characters")
    private String firstName;

    @Size(min=2, max=50, message = "Entered last name must contain at least 2 characters and a maximum of 30 characters")
    private String lastName;

    @Pattern(regexp = "^(\\+?[0-9]{3}|0)[0-9]{9}$", message = "Please enter a valid phone number")
    private String phoneNumber;

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid e-mail address")
    private String email;

    public Customer() {}

    public Customer(String customerId, String firstName, String lastName, String phoneNumber, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        Customer customer = (Customer) o;
        return getCustomerId().equals(customer.getCustomerId()) && getFirstName().equals(customer.getFirstName()) && getLastName().equals(customer.getLastName()) && getPhoneNumber().equals(customer.getPhoneNumber()) && getEmail().equals(customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getFirstName(), getLastName(), getPhoneNumber(), getEmail());
    }
}