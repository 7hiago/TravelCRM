package org.laba2.dao.postgresImpl;

import org.apache.log4j.Logger;
import org.laba2.dao.OrderDAO;
import org.laba2.entities.Order;
import org.laba2.exception.DatabaseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
@DependsOn("datasource")
public class PostgresOrderDAOImpl implements OrderDAO {

    private static final Logger logger = Logger.getLogger(PostgresOrderDAOImpl.class);

    private final DataSource dataSource;

    public PostgresOrderDAOImpl(@Qualifier("datasource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createOrder(Order order) {
        logger.debug("invocation create order method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders_table (tour_id, customer_id, manager_id, accounting_id, date, status) VALUES (?,?,?,?,?,?)")) {
            preparedStatement.setString(1, order.getTourId());
            preparedStatement.setString(2, order.getCustomerId());
            preparedStatement.setString(3, order.getManagerId());
            preparedStatement.setString(4, order.getAccountingId());
            preparedStatement.setDate(5, Date.valueOf(order.getDate()));
            preparedStatement.setString(6, order.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }

    }

    @Override
    public Order getOrder(int order_id) {
        logger.debug("invocation get order method");
        Order order = null;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders_table WHERE order_id=?")) {
            preparedStatement.setInt(1, order_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order = parseOrder(resultSet);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return order;
    }

    @Override
    public List<Order> getOrders() {
        logger.debug("invocation get orders method");
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders_table ORDER BY order_id");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                orderList.add(parseOrder(resultSet));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return orderList;
    }

    @Override
    public List<Order> getAvailableOrdersForManager(String managerId) {
        logger.debug("invocation get available orders for manager method");
        List<Order> orderList = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders_table WHERE manager_id=? ORDER BY date")) {
            preparedStatement.setString(1, managerId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderList.add(parseOrder(resultSet));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return orderList;
    }

    @Override
    public void updateOrder(int order_id, Order order) {
        logger.debug("invocation update order method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE orders_table SET tour_id=?, customer_id=?, manager_id=?, accounting_id=?, date=?, status=? WHERE order_id=?")) {
            preparedStatement.setString(1, order.getTourId());
            preparedStatement.setString(2, order.getCustomerId());
            preparedStatement.setString(3, order.getManagerId());
            preparedStatement.setString(4, order.getAccountingId());
            preparedStatement.setDate(5, Date.valueOf(order.getDate()));
            preparedStatement.setString(6, order.getStatus());
            preparedStatement.setInt(7, order_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public void removeOrder(int order_id) {
        logger.debug("invocation remove order method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM orders_table WHERE order_id=?")) {
            preparedStatement.setInt(1, order_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    private Order parseOrder(ResultSet resultSet) {
        logger.debug("invocation parse order method");
        Order order = null;
        try {
            int order_id = resultSet.getInt("order_id");
            String tour_id = resultSet.getString("tour_id");
            String customer_id = resultSet.getString("customer_id");
            String manager_id = resultSet.getString("manager_id");
            String accounting_id = resultSet.getString("accounting_id");
            String date = resultSet.getString("date");
            String status = resultSet.getString("status");
            order = new Order(order_id, tour_id, customer_id,
                    manager_id, accounting_id, date, status);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return order;
    }

}
