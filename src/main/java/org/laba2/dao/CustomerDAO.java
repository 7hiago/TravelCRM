package org.laba2.dao;

import org.laba2.entities.Customer;

import java.util.List;

public interface CustomerDAO {
    void createCustomer(Customer customer);
    Customer getCustomer(String customer_id);
    List<Customer> getCustomers();
    void updateCustomer(String customer_id, Customer customer);
    void removeCustomer(String customer_id);
}
