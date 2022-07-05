package org.laba2.dto;

import org.laba2.entities.Accounting;
import org.laba2.entities.Customer;
import org.laba2.entities.Tour;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CreateOrderDTO {

    @NotNull
    @Valid
    private Tour tour;

    @NotNull
    @Valid
    private Customer customer;

    @NotNull
    @Valid
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateOrderDTO)) return false;
        CreateOrderDTO that = (CreateOrderDTO) o;
        return getTour().equals(that.getTour()) && getCustomer().equals(that.getCustomer()) && getAccounting().equals(that.getAccounting());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTour(), getCustomer(), getAccounting());
    }

    @Override
    public String toString() {
        StringBuilder createOrderDTOToString = new StringBuilder()
                .append("CreateOrderDTO: ").append('\n')
                .append("tour: ").append(tour).append(',').append('\n')
                .append("customer: ").append(customer).append(',').append('\n')
                .append("accounting: ").append(accounting).append('.');
        return createOrderDTOToString.toString();
    }
}
