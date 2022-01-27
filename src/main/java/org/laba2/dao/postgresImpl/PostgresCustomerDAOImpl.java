package org.laba2.dao.postgresImpl;

import org.laba2.dao.CustomerDAO;
import org.laba2.entities.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@DependsOn("datasource")
public class PostgresCustomerDAOImpl implements CustomerDAO {

    private final DataSource dataSource;

    public PostgresCustomerDAOImpl(@Qualifier("datasource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createCustomer(Customer customer) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers_table (customer_id, customer_firstname, customer_lastname, customer_phonenumber, customer_email) VALUES (?,?,?,?,?)"))
        {
            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getEmail());

            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item customer already exist");
            else System.out.println("Customer added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String customer_id) {
        Customer customer = null;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers_table WHERE customer_id=?"))
        {
            preparedStatement.setString(1, customer_id);
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
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers_table ORDER BY customer_firstname");
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
    public void updateCustomer(String customer_id, Customer customer) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE customers_table SET customer_firstname=?, customer_lastname=?, customer_phonenumber=?, customer_email=? WHERE customer_id=?"))
        {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item customer not exist");
            System.out.println("Customer updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCustomer(String customer_id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM customers_table WHERE customer_id=?"))
        {
            preparedStatement.setString(1, customer_id);
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
            String manager_id = resultSet.getString("customer_id");
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
