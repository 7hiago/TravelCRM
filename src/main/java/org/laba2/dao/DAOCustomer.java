package org.laba2.dao;

import org.laba2.entities.Customer;

public interface DAOCustomer {
    void createCustomer(Customer customer);
    Customer getCustomer(String customer_id);
    void updateCustomer(String customer_id, Customer customer);
    void removeCustomer(String customer_id);
}
