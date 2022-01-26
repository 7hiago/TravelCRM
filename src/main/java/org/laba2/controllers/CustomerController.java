package org.laba2.controllers;

import org.laba2.dao.CustomerDAO;
import org.laba2.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/customers")
public class CustomerController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/showCustomers")
    public ModelAndView showCustomers() {
        return new ModelAndView("./customers/showCustomers", "customers", customerDAO.getCustomers());
    }

    @GetMapping("/showCustomer/{customerId}")
    public ModelAndView showCustomer(@PathVariable("customerId") String customerId) {
        return new ModelAndView("./customers/showCustomer", "customer", customerDAO.getCustomer(customerId));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createCustomer")
    public ModelAndView createCustomer() {
        return new ModelAndView("./customers/createCustomer", "command", new Customer());
    }

    @PostMapping("/saveCreatedCustomer")
    public ModelAndView saveCreatedCustomer(@ModelAttribute Customer customer) {
        customerDAO.createCustomer(customer);
        return new ModelAndView("redirect:/customers/showCustomers");
    }

    @GetMapping("/{customerId}/editCustomer")
    public ModelAndView editCustomer(@PathVariable("customerId") String customerId) {
        return new ModelAndView("./customers/editCustomer", "command", customerDAO.getCustomer(customerId));
    }

    @PatchMapping("/saveEditedCustomer/{customerId}")
    public ModelAndView saveEditedCustomer(@ModelAttribute Customer customer, @PathVariable("customerId") String customerId) {
        customerDAO.updateCustomer(customerId, customer);
        return new ModelAndView("redirect:/customers/showCustomers");
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ModelAndView deleteCustomer(@PathVariable("customerId") String customerId) {
        customerDAO.removeCustomer(customerId);
        return new ModelAndView("redirect:/customers/showCustomers");
    }
}
