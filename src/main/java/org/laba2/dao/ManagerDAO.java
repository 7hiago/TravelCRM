package org.laba2.dao;

import org.laba2.entities.Manager;

import java.util.List;

public interface ManagerDAO {
    void createManager(Manager manager);
    Manager getManager(int manager_id);
    List<Manager> getManagers();
    void updateManager(int manager_id, Manager manager);
    void removeManager(int manager_id);
}
