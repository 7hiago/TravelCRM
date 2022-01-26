package org.laba2.services;

import org.laba2.dao.TourDAO;
import org.laba2.entities.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private final TourDAO tourDAO;

    @Autowired
    public TourService(TourDAO tourDAO) {
        this.tourDAO = tourDAO;
    }

    public void createNewTour(Tour tour) {
        tourDAO.createTour(tour);
    }

    public Tour getTourById(String tourId) {
        return tourDAO.getTour(tourId);
    }
}
