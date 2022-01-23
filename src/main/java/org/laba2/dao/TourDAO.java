package org.laba2.dao;

import org.laba2.entities.Tour;

public interface TourDAO {
    void createTour(Tour tour);
    Tour getTour(int tour_id);
    void updateTour(int tour_id, Tour tour);
    void removeTour(int tour_id);
}
