package org.laba2.dao;

import org.laba2.entities.Touroperator;

import java.util.List;

public interface TouroperatorDAO {
    void createTouroperator(Touroperator touroperator);
    Touroperator getTouroperator(int touroperator_id);
    List<Touroperator> getTouroperators();
    void updateTouroperator(int touroperator_id, Touroperator touroperator);
    void removeTouroperator(int touroperator_id);
}
