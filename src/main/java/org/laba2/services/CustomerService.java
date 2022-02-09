package org.laba2.services;

import org.laba2.dao.CustomerDAO;
import org.laba2.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public String createNewCustomer(Customer newCustomer) {
        List<Customer> customersFromDB = customerDAO.getCustomers();
        customersFromDB = customersFromDB.stream().filter(existCustomer -> existCustomer.getEmail().equals(newCustomer.getEmail())
                || existCustomer.getPhoneNumber().equals(newCustomer.getPhoneNumber())).collect(Collectors.toList());
        if(customersFromDB.size() != 0) {
            return customersFromDB.get(0).getCustomerId();
        }
        newCustomer.setCustomerId("CT-" + UUID.randomUUID());
        customerDAO.createCustomer(newCustomer);
        return newCustomer.getCustomerId();
    }

    public Customer getCustomerById(String customerId) {
        return customerDAO.getCustomer(customerId);
    }

    public List<Customer> getAvailableCustomers() {
        return customerDAO.getCustomers();
    }

    public void editCustomer(String customerId,Customer editedCustomer) {
        customerDAO.updateCustomer(customerId, editedCustomer);
    }

    public void deleteCustomer(String customerId) {
        customerDAO.removeCustomer(customerId);
    }

}