package org.laba2.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Tour {
    private String tourId;
    private String country;
    private String hotel;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private String proposalNumber;
    private String touroperatorId;

    public Tour() {}

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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    public String getTouroperatorId() {
        return touroperatorId;
    }

    public void setTouroperatorId(String touroperatorId) {
        this.touroperatorId = touroperatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return getTourId().equals(tour.getTourId()) && getCountry().equals(tour.getCountry()) && getHotel().equals(tour.getHotel()) && getDepartureDate().equals(tour.getDepartureDate()) && getReturnDate().equals(tour.getReturnDate()) && getProposalNumber().equals(tour.getProposalNumber()) && getTouroperatorId().equals(tour.getTouroperatorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTourId(), getCountry(), getHotel(), getDepartureDate(), getReturnDate(), getProposalNumber(), getTouroperatorId());
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId='" + tourId + '\'' +
                ", country='" + country + '\'' +
                ", hotel='" + hotel + '\'' +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                ", proposalNumber='" + proposalNumber + '\'' +
                ", touroperatorId='" + touroperatorId + '\'' +
                '}';
    }
}
