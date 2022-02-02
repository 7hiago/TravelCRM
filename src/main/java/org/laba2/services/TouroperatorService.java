package org.laba2.services;

import org.laba2.dao.TouroperatorDAO;
import org.laba2.entities.Touroperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public Touroperator getTouroperatorById(String touroperatorId) {
        return touroperatorDAO.getTouroperator(touroperatorId);
    }

    public boolean createNewTouroperator(Touroperator newTouroperator) {
        List<Touroperator> touroperatorsFromDB = touroperatorDAO.getTouroperators();
        touroperatorsFromDB = touroperatorsFromDB.stream().filter(existTouroperator -> existTouroperator.getEmail().equals(newTouroperator.getEmail())
                || existTouroperator.getPhoneNumber().equals(newTouroperator.getPhoneNumber())).collect(Collectors.toList());
        if(touroperatorsFromDB.size() != 0) {
            return false;
        }
        newTouroperator.setTouroperatorId("TR-" + UUID.randomUUID());
        touroperatorDAO.createTouroperator(newTouroperator);
        return true;


    }

    public void editTouroperator(String touroperatorId,Touroperator editedTouroperator) {
        touroperatorDAO.updateTouroperator(touroperatorId, editedTouroperator);
    }

    public void deleteTouroperator(String touroperatorId) {
        touroperatorDAO.removeTouroperator(touroperatorId);
    }

}
