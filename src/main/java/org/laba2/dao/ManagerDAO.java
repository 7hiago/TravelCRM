package org.laba2.dao;

import org.laba2.entities.Manager;

import java.util.List;

public interface ManagerDAO {
    void createManager(Manager manager);
    Manager getManagerById(String manager_id);
    Manager getManagerByLogin(String manager_login);
    List<Manager> getManagers();
    void updateManager(String manager_id, Manager manager);
    void removeManager(String manager_id);
}