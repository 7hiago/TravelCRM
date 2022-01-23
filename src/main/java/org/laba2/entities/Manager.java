package org.laba2.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Manager {
    private int managerId;
    private String firstName;
    private String lastName;
    private float salary;
    private LocalDate hireDate;
    private String phoneNumber;
    private String email;
    private String login;
    private String password;

    public Manager() {}

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return getManagerId() == manager.getManagerId() && Float.compare(manager.getSalary(), getSalary()) == 0 && getFirstName().equals(manager.getFirstName()) && getLastName().equals(manager.getLastName()) && getHireDate().equals(manager.getHireDate()) && getPhoneNumber().equals(manager.getPhoneNumber()) && getEmail().equals(manager.getEmail()) && getLogin().equals(manager.getLogin()) && getPassword().equals(manager.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManagerId(), getFirstName(), getLastName(), getSalary(), getHireDate(), getPhoneNumber(), getEmail(), getLogin(), getPassword());
    }

}
