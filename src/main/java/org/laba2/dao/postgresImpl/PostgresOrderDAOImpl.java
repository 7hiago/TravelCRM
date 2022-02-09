package org.laba2.dao.postgresImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.dao.OrderDAO;
import org.laba2.entities.Order;
import org.laba2.exception.DatabaseException;
import org.laba2.utils.ResultSetToOrderConverter;
import org.laba2.utils.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostgresOrderDAOImpl implements OrderDAO {

    private static final Logger logger = LogManager.getLogger(PostgresOrderDAOImpl.class);

    @Autowired
    private StringToDateConverter stringToDateConverter;

    @Autowired
    private ResultSetToOrderConverter resultSetToOrderConverter;

    private final DataSource dataSource;

    public PostgresOrderDAOImpl(DataSource dataSource) {
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
            preparedStatement.setDate(5, stringToDateConverter.convert(order.getDate()));
            preparedStatement.setString(6, order.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }

    }

    @Override
    public Order getOrder(int order_id) {
        logger.debug("invocation get order method");
        Order order;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders_table WHERE order_id=?")) {
            preparedStatement.setInt(1, order_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order = resultSetToOrderConverter.convert(resultSet);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("Problem with closing result set" + e.getMessage());
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
                orderList.add(resultSetToOrderConverter.convert(resultSet));
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
                orderList.add(resultSetToOrderConverter.convert(resultSet));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("Problem with closing result set" + e.getMessage());
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
            preparedStatement.setDate(5, stringToDateConverter.convert(order.getDate()));
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
}