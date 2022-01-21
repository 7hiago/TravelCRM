package org.laba2.dao;

import org.laba2.entities.Tour;

public interface DAOTour {
    void createTour(Tour tour);
    Tour getTour(String tour_id);
    void updateTour(String tour_id, Tour tour);
    void removeTour(String tour_id);
}
