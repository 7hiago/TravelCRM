package org.laba2.dto;

import org.laba2.entities.Accounting;
import org.laba2.entities.Customer;
import org.laba2.entities.Manager;
import org.laba2.entities.Tour;

public class ShowOrderDTO {

    private int orderNumber;
    private Tour tour;
    private Customer customer;
    private Manager manager;
    private Accounting accounting;
    private String date;
    private String status;

    public ShowOrderDTO() {}

    public ShowOrderDTO(int orderNumber, Tour tour, Customer customer, Manager manager, Accounting accounting, String date, String status) {
        this.orderNumber = orderNumber;
        this.tour = tour;
        this.customer = customer;
        this.manager = manager;
        this.accounting = accounting;
        this.date = date;
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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
