package org.laba2.controllers;

import org.laba2.entities.Customer;
import org.laba2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/showCustomers")
    public ModelAndView showCustomers() {
        return new ModelAndView("./customers/showCustomers", "customers", customerService.getAvailableCustomers());
    }

    @GetMapping("/showCustomer/{customerId}")
    public ModelAndView showCustomer(@PathVariable("customerId") String customerId) {
        return new ModelAndView("./customers/showCustomer", "customer", customerService.getCustomerById(customerId));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createCustomer")
    public ModelAndView createCustomer() {
        return new ModelAndView("./customers/createCustomer", "command", new Customer());
    }

    @PostMapping("/saveCreatedCustomer")
    public ModelAndView saveCreatedCustomer(@ModelAttribute Customer customer) {
        customerService.createNewCustomer(customer);
        return new ModelAndView("redirect:/customers/showCustomers");
    }

    @GetMapping("/{customerId}/editCustomer")
    public ModelAndView editCustomer(@PathVariable("customerId") String customerId) {
        return new ModelAndView("./customers/editCustomer", "command", customerService.getCustomerById(customerId));
    }

    @PatchMapping("/saveEditedCustomer/{customerId}")
    public ModelAndView saveEditedCustomer(@ModelAttribute Customer customer, @PathVariable("customerId") String customerId) {
        customerService.editCustomer(customerId, customer);
        return new ModelAndView("redirect:/customers/showCustomers");
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ModelAndView deleteCustomer(@PathVariable("customerId") String customerId) {
        customerService.deleteCustomer(customerId);
        return new ModelAndView("redirect:/customers/showCustomers");
    }
}
