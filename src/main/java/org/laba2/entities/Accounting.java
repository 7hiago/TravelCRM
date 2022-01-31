package org.laba2.entities;

import java.util.Objects;

public class Accounting {
    private String accountingId;
    private float tourPrice;
    private float tourPaid;
    private float commission;
    private float touroperatorPrice;
    private float touroperatorPaid;
    private float profit;

    public Accounting() {}

    public Accounting(String accountingId, float tourPrice, float tourPaid, float commission, float touroperatorPrice, float touroperatorPaid, float profit) {
        this.accountingId = accountingId;
        this.tourPrice = tourPrice;
        this.tourPaid = tourPaid;
        this.commission = commission;
        this.touroperatorPrice = touroperatorPrice;
        this.touroperatorPaid = touroperatorPaid;
        this.profit = profit;
    }

    public String getAccountingId() {
        return accountingId;
    }

    public void setAccountingId(String accountingId) {
        this.accountingId = accountingId;
    }

    public float getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(float tourPrice) {
        this.tourPrice = tourPrice;
    }

    public float getTourPaid() {
        return tourPaid;
    }

    public void setTourPaid(float tourPaid) {
        this.tourPaid = tourPaid;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getTouroperatorPrice() {
        return touroperatorPrice;
    }

    public void setTouroperatorPrice(float touroperatorPrice) {
        this.touroperatorPrice = touroperatorPrice;
    }

    public float getTouroperatorPaid() {
        return touroperatorPaid;
    }

    public void setTouroperatorPaid(float touroperatorPaid) {
        this.touroperatorPaid = touroperatorPaid;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounting that = (Accounting) o;
        return getAccountingId().equals(that.getAccountingId()) && Float.compare(that.getTourPrice(), getTourPrice()) == 0 && Float.compare(that.getTourPaid(), getTourPaid()) == 0 && Float.compare(that.getCommission(), getCommission()) == 0 && Float.compare(that.getTouroperatorPrice(), getTouroperatorPrice()) == 0 && Float.compare(that.getTouroperatorPaid(), getTouroperatorPaid()) == 0 && Float.compare(that.getProfit(), getProfit()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountingId(), getTourPrice(), getTourPaid(), getCommission(), getTouroperatorPrice(), getTouroperatorPaid(), getProfit());
    }
}
