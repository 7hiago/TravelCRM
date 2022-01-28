package org.laba2.services;

import org.laba2.dao.ManagerDAO;
import org.laba2.entities.Manager;
import org.laba2.entities.Role;
import org.laba2.entities.Status;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManagerService {

    private final ManagerDAO managerDAO;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ManagerService(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public List<Manager> getAvailableManagers() {
        return managerDAO.getManagers();
    }

    public Manager getManagerById(String managerId) {
        return managerDAO.getManagerById(managerId);
    }

    public Manager getManagerByLogin(String managerLogin) {
        return managerDAO.getManagerByLogin(managerLogin);
    }

    public void createNewManager(Manager newManager) {
        newManager.setManagerId("TR-" + UUID.randomUUID());
        newManager.setRole(Role.MANAGER);
        newManager.setStatus(Status.ACTIVE);
        managerDAO.createManager(newManager);
    }

    public void editManager(String managerId,Manager editedManager) {
        managerDAO.updateManager(managerId, editedManager);
    }

    public void deleteManager(String managerId) {
        managerDAO.removeManager(managerId);
    }

}
