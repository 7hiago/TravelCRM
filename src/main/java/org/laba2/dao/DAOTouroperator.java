package org.laba2.dao;

import org.laba2.entities.Touroperator;

public interface DAOTouroperator {
    void createTouroperator(Touroperator touroperator);
    Touroperator getTouroperator(String tour_id);
    void updateTouroperator(String tour_id, Touroperator touroperator);
    void removeTouroperator(String tour_id);
}
