package org.laba2.utils;

import org.laba2.entities.Order;
import org.laba2.exception.DatabaseException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResultSetToOrderConverter implements Converter<ResultSet, Order> {
    @Override
    public Order convert(ResultSet source) {
        Order order;
        try {
            int order_id = source.getInt("order_id");
            String tour_id = source.getString("tour_id");
            String customer_id = source.getString("customer_id");
            String manager_id = source.getString("manager_id");
            String accounting_id = source.getString("accounting_id");
            String date = source.getString("date");
            String status = source.getString("status");
            order = new Order(order_id, tour_id, customer_id,
                    manager_id, accounting_id, date, status);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return order;
    }
}