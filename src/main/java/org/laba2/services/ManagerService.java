package org.laba2.services;

import org.laba2.dao.ManagerDAO;
import org.laba2.entities.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    private final ManagerDAO managerDAO;

    @Autowired
    public ManagerService(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public List<Manager> getAvailableManagers() {
        return managerDAO.getManagers();
    }

    public Manager getManagerById(String managerId) {
        return managerDAO.getManager(managerId);
    }

}
