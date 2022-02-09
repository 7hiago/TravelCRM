package org.laba2.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Manager implements UserDetails {
    private String managerId;

    @Size(min=2, max=30, message = "Entered first name must contain at least 2 characters and a maximum of 30 characters")
    private String firstName;

    @Size(min=2, max=30, message = "Entered last name must contain at least 2 characters and a maximum of 30 characters")
    private String lastName;

    @Min(value = 1, message = "Entered value must be greater than 0")
    private float salary;

    @NotBlank(message = "Hire date must not be blank")
    private String hireDate;

    @Pattern(regexp = "^(\\+?[0-9]{3}|0)[0-9]{9}$", message = "Please enter a valid phone number")
    private String phoneNumber;

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid e-mail address")
    private String email;

    @Size(min=8, max=20, message = "Entered login must contain min 8, max 20 symbols")
    @Pattern(regexp = "[a-zA-Z0-9_.]*", message = "Please enter a valid login")
    private String login;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,30}$", message = "Please enter a valid password: it must contain at least one digit, at least one lowercase Latin character, at least one uppercase Latin character, at least one special character like ! @ # & ( ), and contain a length of at least 8 characters and a maximum of 30 characters")
    private String password;

    @NotBlank(message = "Role must not be blank")
    private String role;

    @NotBlank(message = "Status must not be blank")
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