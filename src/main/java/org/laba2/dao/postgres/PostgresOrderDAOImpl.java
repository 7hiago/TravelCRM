package org.laba2.dao.postgres;

import org.laba2.dao.OrderDAO;
import org.laba2.entities.Order;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresOrderDAOImpl implements OrderDAO {

    @Override
    public void createOrder(Order order) {

        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders_table (tour_id, customer_id, manager_id, accounting_id, date, status) VALUES (?,?,?,?,?,?)"))
        {
            preparedStatement.setInt(1, order.getTourId());
            preparedStatement.setInt(2, order.getCustomerId());
            preparedStatement.setInt(3, order.getManagerId());
            preparedStatement.setInt(4, order.getAccountingId());
            preparedStatement.setDate(5, Date.valueOf(order.getDate()));
            preparedStatement.setString(6, order.getStatus());
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item already exist");
            else System.out.println("Added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Order getOrder(int order_id) {
        Order order = null;
        ResultSet resultSet = null;
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders_table WHERE order_id=?"))
        {
            preparedStatement.setInt(1, order_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order = parseOrder(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try { resultSet.close();} catch (SQLException e) { e.printStackTrace();}
            }
        }
        return order;
    }

    @Override
    public List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();
        try(Connection connection = PostgresDAOFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders_table ORDER BY order_id");
            ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                orderList.add(parseOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public void updateOrder(int order_id, Order order) {

        try(Connection connection = PostgresDAOFactory.createConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE orders_table SET tour_id=?, customer_id=?, manager_id=?, accounting_id=?, date=?, status=? WHERE order_id=?"))
        {
            preparedStatement.setInt(1, order.getTourId());
            preparedStatement.setInt(2, order.getCustomerId());
            preparedStatement.setInt(3, order.getManagerId());
            preparedStatement.setInt(4, order.getAccountingId());
            preparedStatement.setDate(5, Date.valueOf(order.getDate()));
            preparedStatement.setString(6, order.getStatus());
            preparedStatement.setInt(7, order_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item not exist");
            System.out.println("Job updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeOrder(int order_id) {

        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM orders_table WHERE order_id=?"))
        {
            preparedStatement.setInt(1, order_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item not exist");
            else System.out.println("Deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Order parseOrder(ResultSet resultSet) {
        Order order = null;
        try {
            int order_id = resultSet.getInt("order_id");
            int tour_id = resultSet.getInt("tour_id");
            int customer_id = resultSet.getInt("customer_id");
            int manager_id = resultSet.getInt("manager_id");
            int accounting_id = resultSet.getInt("accounting_id");
            String  date = resultSet.getString("date");
            String  status = resultSet.getString("status");
            order = new Order(order_id, tour_id, customer_id,
                    manager_id, accounting_id, date, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

}
