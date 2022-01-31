package org.laba2.dto;

import org.laba2.entities.Tour;
import org.laba2.entities.Touroperator;

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
}
