package org.laba2.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private int orderId;
    private int tourId;
    private int customerId;
    private int managerId;
    private int accountingId;
    private String date;
    private String status;

    public Order() {}

    public Order(int orderId, int tourId, int customerId, int managerId, int accountingId, String date, String status) {
        this.orderId = orderId;
        this.tourId = tourId;
        this.customerId = customerId;
        this.managerId = managerId;
        this.accountingId = accountingId;
        this.date = date;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getAccountingId() {
        return accountingId;
    }

    public void setAccountingId(int accountingId) {
        this.accountingId = accountingId;
    }

    public String getDate()  {
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
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() && getTourId() == order.getTourId() && getCustomerId() == order.getCustomerId() && getManagerId() == order.getManagerId() && getAccountingId() == order.getAccountingId() && getDate().equals(order.getDate()) && getStatus().equals(order.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getTourId(), getCustomerId(), getManagerId(), getAccountingId(), getDate(), getStatus());
    }
}
