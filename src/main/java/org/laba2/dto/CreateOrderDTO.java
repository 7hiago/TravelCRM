package org.laba2.dto;

import org.laba2.entities.*;

public class CreateOrderDTO {

    private Tour tour;
    private Customer customer;
    private String selectedManagerId;
    private Accounting accounting;
    private String date;
    private String status;

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

    public String getSelectedManagerId() {
        return selectedManagerId;
    }

    public void setSelectedManagerId(String selectedManagerId) {
        this.selectedManagerId = selectedManagerId;
    }

    public Accounting getAccounting() {
        return accounting;
    }

    public void setAccounting(Accounting accounting) {
        this.accounting = accounting;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
