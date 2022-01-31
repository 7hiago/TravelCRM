package org.laba2.services;

import org.laba2.dao.ManagerDAO;
import org.laba2.entities.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ManagerService implements UserDetailsService {

    private final ManagerDAO managerDAO;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ManagerService(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public List<Manager> getAvailableManagers() {
        List<Manager> managerList = managerDAO.getManagers();
        for(Manager manager : managerList) {
            manager.setRole(manager.getRole().equals("ROLE_ADMIN") ? "ADMIN" : "MANAGER");
        }
        return managerList;
    }

    public Manager getManagerById(String managerId) {
        Manager manager = managerDAO.getManagerById(managerId);
        manager.setRole(manager.getRole().equals("ROLE_ADMIN") ? "ADMIN" : "MANAGER");
        return manager;
    }

    public Manager getManagerByLogin(String managerLogin) {
        return managerDAO.getManagerByLogin(managerLogin);
    }

    public boolean createNewManager(Manager newManager) {
        List<Manager> managersFromDB = managerDAO.getManagers();
        managersFromDB = managersFromDB.stream().filter(existManager -> existManager.getEmail().equals(newManager.getEmail())
                || existManager.getPhoneNumber().equals(newManager.getPhoneNumber())
                || existManager.getLogin().equals(newManager.getLogin())).collect(Collectors.toList());
        if(managersFromDB.size() != 0) {
            return false;
        }
        newManager.setManagerId("TR-" + UUID.randomUUID());
        newManager.setPassword(passwordEncoder.encode(newManager.getPassword()));
        newManager.setRole("ROLE_" + newManager.getRole());
        managerDAO.createManager(newManager);
        return true;
    }

    public void editManager(String managerId, Manager editedManager) {
        Manager notEditManager = managerDAO.getManagerById(managerId);

        if (!notEditManager.getPassword().equals(editedManager.getPassword())) {
            editedManager.setPassword(passwordEncoder.encode(editedManager.getPassword()));
        }
        editedManager.setRole("ROLE_" + editedManager.getRole());
        managerDAO.updateManager(managerId, editedManager);
    }

    public void deleteManager(String managerId) {
        managerDAO.removeManager(managerId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerDAO.getManagerByLogin(username);
            if(manager == null) throw new UsernameNotFoundException("User not found");
        return manager;
    }
}
