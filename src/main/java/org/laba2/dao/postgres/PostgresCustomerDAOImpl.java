package org.laba2.dao.postgres;

import org.laba2.dao.CustomerDAO;
import org.laba2.entities.Customer;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresCustomerDAOImpl implements CustomerDAO {

    @Override
    public void createCustomer(Customer customer) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers_table (customer_firstname, customer_lastname, customer_phonenumber, customer_email) VALUES (?,?,?,?)"))
        {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setString(4, customer.getEmail());

            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item customer already exist");
            else System.out.println("Customer added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(int customer_id) {
        Customer customer = null;
        ResultSet resultSet = null;
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers_table WHERE customer_id=?"))
        {
            preparedStatement.setInt(1, customer_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customer = parseCustomer(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try { resultSet.close();} catch (SQLException e) { e.printStackTrace();}
            }
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try(Connection connection = PostgresDAOFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers_table ORDER BY customer_id");
            ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                customerList.add(parseCustomer(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void updateCustomer(int customer_id, Customer customer) {
        try(Connection connection = PostgresDAOFactory.createConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE customers_table SET customer_firstname=?, customer_lastname=?, customer_phonenumber=?, customer_email=? WHERE customer_id=?"))
        {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setInt(5, customer_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item customer not exist");
            System.out.println("Customer updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCustomer(int customer_id) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM customers_table WHERE customer_id=?"))
        {
            preparedStatement.setInt(1, customer_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item customer not exist");
            else System.out.println("Customer deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer parseCustomer(ResultSet resultSet) {
        Customer customer = null;
        try {
            int manager_id = resultSet.getInt("customer_id");
            String firstname = resultSet.getString("customer_firstname");
            String lastname = resultSet.getString("customer_lastname");
            String phoneNumber = resultSet.getString("customer_phonenumber");
            String email = resultSet.getString("customer_email");
            customer = new Customer(manager_id, firstname, lastname, phoneNumber, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
