package org.laba2.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private String orderId;
    private String tourId;
    private String customerId;
    private String managerId;
    private String accountingId;
    private LocalDate date;
    private String status;

    public Order() {}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
        return getOrderId().equals(order.getOrderId()) && getTourId().equals(order.getTourId()) && getCustomerId().equals(order.getCustomerId()) && getManagerId().equals(order.getManagerId()) && getAccountingId().equals(order.getAccountingId()) && getDate().equals(order.getDate()) && getStatus().equals(order.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getTourId(), getCustomerId(), getManagerId(), getAccountingId(), getDate(), getStatus());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", tourId='" + tourId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", managerId='" + managerId + '\'' +
                ", accountingId='" + accountingId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
