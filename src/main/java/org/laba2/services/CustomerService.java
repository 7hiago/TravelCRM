package org.laba2.services;

import org.laba2.dao.CustomerDAO;
import org.laba2.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void createNewCustomer(Customer customer) {
        customerDAO.createCustomer(customer);
    }

    public Customer getCustomerById(String customerId) {
        return customerDAO.getCustomer(customerId);
    }
}
