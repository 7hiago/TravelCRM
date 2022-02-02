package org.laba2.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.entities.Customer;
import org.laba2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/showCustomers")
    public ModelAndView showCustomers() {
        logger.debug("invocation show customers method");
        return new ModelAndView("./customers/showCustomers", "customers", customerService.getAvailableCustomers());
    }

    @GetMapping("/showCustomer/{customerId}")
    public ModelAndView showCustomer(@PathVariable("customerId") String customerId) {
        logger.debug("invocation show customer method");
        return new ModelAndView("./customers/showCustomer", "customer", customerService.getCustomerById(customerId));
    }

    @GetMapping("/createCustomer")
    public ModelAndView createCustomer() {
        logger.debug("invocation create customer method");
        return new ModelAndView("./customers/createCustomer", "command", new Customer());
    }

    @PostMapping("/saveCreatedCustomer")
    public ModelAndView saveCreatedCustomer(@ModelAttribute Customer customer) {
        logger.debug("invocation save created customer method");
        customerService.createNewCustomer(customer);
        return new ModelAndView("redirect:/customers/showCustomers");
    }

    @GetMapping("/{customerId}/editCustomer")
    public ModelAndView editCustomer(@PathVariable("customerId") String customerId) {
        logger.debug("invocation edit customer method");
        return new ModelAndView("./customers/editCustomer", "command", customerService.getCustomerById(customerId));
    }

    @PatchMapping("/saveEditedCustomer/{customerId}")
    public ModelAndView saveEditedCustomer(@ModelAttribute Customer customer, @PathVariable("customerId") String customerId) {
        logger.debug("invocation save edited customer method");
        customerService.editCustomer(customerId, customer);
        return new ModelAndView("redirect:/customers/showCustomers");
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView deleteCustomer(@PathVariable("customerId") String customerId) {
        logger.debug("invocation delete customer method");
        customerService.deleteCustomer(customerId);
        return new ModelAndView("redirect:/customers/showCustomers");
    }
}
