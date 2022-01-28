package org.laba2.entities;

import java.util.Objects;

public class Manager {
    private String managerId;
    private String firstName;
    private String lastName;
    private float salary;
    private String hireDate;
    private String phoneNumber;
    private String email;
    private String login;
    private String password;
    private Role role;
    private Status status;


    public Manager() {}

    public Manager(String managerId, String firstName, String lastName, float salary, String hireDate, String phoneNumber, String email, String login, String password, Role role, Status status) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.hireDate = hireDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
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

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
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

    public Role getRole() {
        Role role = Role.MANAGER;
        role.getDeclaringClass();
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return getManagerId().equals(manager.getManagerId()) && Float.compare(manager.getSalary(), getSalary()) == 0 && getFirstName().equals(manager.getFirstName()) && getLastName().equals(manager.getLastName()) && getHireDate().equals(manager.getHireDate()) && getPhoneNumber().equals(manager.getPhoneNumber()) && getEmail().equals(manager.getEmail()) && getLogin().equals(manager.getLogin()) && getPassword().equals(manager.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManagerId(), getFirstName(), getLastName(), getSalary(), getHireDate(), getPhoneNumber(), getEmail(), getLogin(), getPassword());
    }

}
