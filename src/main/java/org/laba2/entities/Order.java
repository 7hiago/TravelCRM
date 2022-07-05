package org.laba2.entities;

import java.util.Objects;

public class Order {
    private int orderId;
    private String tourId;
    private String customerId;
    private String managerId;
    private String accountingId;
    private String date;
    private String status;

    public Order() {}

    public Order(int orderId, String tourId, String customerId, String managerId, String accountingId, String date, String status) {
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

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getAccountingId() {
        return accountingId;
    }

    public void setAccountingId(String accountingId) {
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
        return getOrderId() == order.getOrderId() && getTourId().equals(order.getTourId()) && getCustomerId().equals(order.getCustomerId()) && getManagerId().equals(order.getManagerId()) && getAccountingId().equals(order.getAccountingId()) && getDate().equals(order.getDate()) && getStatus().equals(order.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getTourId(), getCustomerId(), getManagerId(), getAccountingId(), getDate(), getStatus());
    }

    @Override
    public String toString() {
        StringBuilder orderToString = new StringBuilder()
                .append("Order: ").append('\n')
                .append("order id: ").append(orderId).append(',').append('\n')
                .append("tour id: ").append(tourId).append(',').append('\n')
                .append("customer id: ").append(customerId).append(',').append('\n')
                .append("manager id: ").append(managerId).append(',').append('\n')
                .append("accounting id: ").append(accountingId).append(',').append('\n')
                .append("date: ").append(date).append(',').append('\n')
                .append("status: ").append(status).append('.');
        return orderToString.toString();
    }
}