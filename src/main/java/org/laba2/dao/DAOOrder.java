package org.laba2.dao;

import org.laba2.entities.Order;

public interface DAOOrder {
    void createOrder(Order order);
    Order getOrder(String order_id);
    void updateOrder(String order_id, Order order);
    void removeOrder(String order_id);
}
