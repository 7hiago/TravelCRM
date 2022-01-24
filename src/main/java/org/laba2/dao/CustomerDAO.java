package org.laba2.dao;

import org.laba2.entities.Customer;

import java.util.List;

public interface CustomerDAO {
    void createCustomer(Customer customer);
    Customer getCustomer(int customer_id);
    List<Customer> getCustomers();
    void updateCustomer(int customer_id, Customer customer);
    void removeCustomer(int customer_id);
}
