package org.laba2.services;

import org.laba2.dao.TourDAO;
import org.laba2.dto.TourDTO;
import org.laba2.entities.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TourService {

    @Autowired
    private TouroperatorService touroperatorService;

    private final TourDAO tourDAO;

    @Autowired
    public TourService(TourDAO tourDAO) {
        this.tourDAO = tourDAO;
    }

    public String createNewTour(Tour tour) {
        tour.setTourId("TR-" + UUID.randomUUID());
        tourDAO.createTour(tour);
        return tour.getTourId();
    }

    public Tour getTourById(String tourId) {
        return tourDAO.getTour(tourId);
    }

    public TourDTO getTourDTOById(String tourId) {
        Tour tour = tourDAO.getTour(tourId);
        return new TourDTO(tour, touroperatorService.getTouroperatorById(tour.getTouroperatorId()));
    }

    public void editTour(String tourId, TourDTO tourDTO) {
        tourDAO.updateTour(tourId, tourDTO.getTour());
    }

    public void deleteTourById(String tourId) {
        tourDAO.removeTour(tourId);
    }
}
