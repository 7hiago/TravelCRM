package org.laba2.dao;

import org.laba2.entities.Manager;

public interface ManagerDAO {
    void createManager(Manager manager);
    Manager getManager(String manager_id);
    void updateManager(String manager_id, Manager manager);
    void removeManager(String manager_id);
}
