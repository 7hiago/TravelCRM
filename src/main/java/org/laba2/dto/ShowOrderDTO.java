package org.laba2.dto;

import org.laba2.entities.Accounting;
import org.laba2.entities.Customer;
import org.laba2.entities.Manager;
import org.laba2.entities.Tour;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowOrderDTO)) return false;
        ShowOrderDTO that = (ShowOrderDTO) o;
        return getOrderNumber() == that.getOrderNumber() && getTour().equals(that.getTour()) && getCustomer().equals(that.getCustomer()) && getManager().equals(that.getManager()) && getAccounting().equals(that.getAccounting()) && getDate().equals(that.getDate()) && getStatus().equals(that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNumber(), getTour(), getCustomer(), getManager(), getAccounting(), getDate(), getStatus());
    }

    @Override
    public String toString() {
        StringBuilder showOrderDTOToString = new StringBuilder()
                .append("ShowOrderDTO: ").append('\n')
                .append("order number: ").append(orderNumber).append(',').append('\n')
                .append("tour: ").append(tour).append(',').append('\n')
                .append("customer: ").append(customer).append(',').append('\n')
                .append("manager: ").append(manager).append(',').append('\n')
                .append("accounting: ").append(accounting).append(',').append('\n')
                .append("date: ").append(date).append(',').append('\n')
                .append("status: ").append(status).append('.');
        return showOrderDTOToString.toString();
    }
}
