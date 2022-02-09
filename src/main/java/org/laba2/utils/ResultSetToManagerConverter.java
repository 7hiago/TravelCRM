package org.laba2.utils;

import org.laba2.entities.Manager;
import org.laba2.exception.DatabaseException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResultSetToManagerConverter implements Converter<ResultSet, Manager> {
    @Override
    public Manager convert(ResultSet source) {
        Manager manager;
        try {
            String manager_id = source.getString("manager_id");
            String firstname = source.getString("manager_firstname");
            String lastname = source.getString("manager_lastname");
            float salary = source.getFloat("manager_salary");
            String hireDate = source.getString("manager_hiredate");
            String phoneNumber = source.getString("manager_phonenumber");
            String email = source.getString("manager_email");
            String login = source.getString("manager_login");
            String password = source.getString("manager_password");
            String role = source.getString("manager_role");
            String status = source.getString("manager_status");
            manager = new Manager(manager_id, firstname, lastname,
                    salary, hireDate, phoneNumber, email, login, password, role, status);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return manager;
    }
}