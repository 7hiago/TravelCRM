package org.laba2.dao;

import org.laba2.entities.Order;

import java.util.List;

public interface OrderDAO {
    void createOrder(Order order);
    Order getOrder(int order_id);
    List<Order> getOrders();
    List<Order> getAvailableOrdersForManager(String managerId);
    void updateOrder(int order_id, Order order);
    void removeOrder(int order_id);
}
