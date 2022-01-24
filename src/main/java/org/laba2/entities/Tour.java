package org.laba2.entities;

import java.util.Objects;

public class Tour {
    private String tourId;
    private String country;
    private String hotel;
    private String departureDate;
    private String returnDate;
    private String proposalNumber;
    private int touroperatorId;

    public Tour(String tourId, String country, String hotel, String departureDate, String returnDate, String proposalNumber, int touroperatorId) {
        this.tourId = tourId;
        this.country = country;
        this.hotel = hotel;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.proposalNumber = proposalNumber;
        this.touroperatorId = touroperatorId;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    public int getTouroperatorId() {
        return touroperatorId;
    }

    public void setTouroperatorId(int touroperatorId) {
        this.touroperatorId = touroperatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return getTourId().equals(tour.getTourId()) && getTouroperatorId() == tour.getTouroperatorId() && getCountry().equals(tour.getCountry()) && getHotel().equals(tour.getHotel()) && getDepartureDate().equals(tour.getDepartureDate()) && getReturnDate().equals(tour.getReturnDate()) && getProposalNumber().equals(tour.getProposalNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTourId(), getCountry(), getHotel(), getDepartureDate(), getReturnDate(), getProposalNumber(), getTouroperatorId());
    }
}
