package org.laba2.services;

import org.laba2.dao.TouroperatorDAO;
import org.laba2.entities.Touroperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouroperatorService {

    private final TouroperatorDAO touroperatorDAO;

    @Autowired
    public TouroperatorService(TouroperatorDAO touroperatorDAO) {
        this.touroperatorDAO = touroperatorDAO;
    }

    public List<Touroperator> getAvailableTouroperators() {
        return touroperatorDAO.getTouroperators();
    }
}
