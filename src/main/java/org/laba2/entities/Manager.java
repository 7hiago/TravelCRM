package org.laba2.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Manager implements UserDetails {
    private String managerId;
    private String firstName;
    private String lastName;
    private float salary;
    private String hireDate;
    private String phoneNumber;
    private String email;
    private String login;
    private String password;
    private String role;
    private String status;


    public Manager() {}

    public Manager(String managerId, String firstName, String lastName, float salary, String hireDate, String phoneNumber, String email, String login, String password, String role, String status) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> arrayList= new ArrayList<>();
        arrayList.add(new Role(role));
        return arrayList;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status.equals("ACTIVE");
    }

    @Override
    public boolean isAccountNonLocked() {
        return status.equals("ACTIVE");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return status.equals("ACTIVE");
    }

    @Override
    public boolean isEnabled() {
        return status.equals("ACTIVE");
    }

    public void setPassword(String password) {
        this.password = password;
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
