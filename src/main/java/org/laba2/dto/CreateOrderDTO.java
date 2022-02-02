package org.laba2.dto;

import org.laba2.entities.Accounting;
import org.laba2.entities.Customer;
import org.laba2.entities.Tour;

public class CreateOrderDTO {

    private Tour tour;
    private Customer customer;
    private Accounting accounting;

    public CreateOrderDTO() {}

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Accounting getAccounting() {
        return accounting;
    }

    public void setAccounting(Accounting accounting) {
        this.accounting = accounting;
    }

}
