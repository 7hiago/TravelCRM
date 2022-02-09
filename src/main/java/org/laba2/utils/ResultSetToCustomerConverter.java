package org.laba2.utils;

import org.laba2.entities.Customer;
import org.laba2.exception.DatabaseException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResultSetToCustomerConverter implements Converter<ResultSet, Customer> {
    @Override
    public Customer convert(ResultSet source) {
        Customer customer;
        try {
            String manager_id = source.getString("customer_id");
            String firstname = source.getString("customer_firstname");
            String lastname = source.getString("customer_lastname");
            String phoneNumber = source.getString("customer_phonenumber");
            String email = source.getString("customer_email");
            customer = new Customer(manager_id, firstname, lastname, phoneNumber, email);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return customer;
    }
}