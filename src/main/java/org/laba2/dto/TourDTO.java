package org.laba2.dto;

import org.laba2.entities.Tour;
import org.laba2.entities.Touroperator;

import java.util.Objects;

public class TourDTO {
    private Tour tour;
    private Touroperator touroperator;

    public TourDTO() {}

    public TourDTO(Tour tour, Touroperator touroperator) {
        this.tour = tour;
        this.touroperator = touroperator;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Touroperator getTouroperator() {
        return touroperator;
    }

    public void setTouroperator(Touroperator touroperator) {
        this.touroperator = touroperator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourDTO)) return false;
        TourDTO tourDTO = (TourDTO) o;
        return getTour().equals(tourDTO.getTour()) && getTouroperator().equals(tourDTO.getTouroperator());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTour(), getTouroperator());
    }

    @Override
    public String toString() {
        StringBuilder tourDTOToString = new StringBuilder()
                .append("TourDTO: ").append('\n')
                .append("tour: ").append(tour).append(',').append('\n')
                .append("touroperator: ").append(touroperator).append('.');
        return tourDTOToString.toString();
    }
}
