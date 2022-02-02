package org.laba2.dao.postgresImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.dao.CustomerDAO;
import org.laba2.entities.Customer;
import org.laba2.exception.DatabaseException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostgresCustomerDAOImpl implements CustomerDAO {

    private static final Logger logger = LogManager.getLogger(PostgresCustomerDAOImpl.class);

    private final DataSource dataSource;

    public PostgresCustomerDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createCustomer(Customer customer) {
        logger.debug("invocation create customer method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers_table (customer_id, customer_firstname, customer_lastname, customer_phonenumber, customer_email) VALUES (?,?,?,?,?)"))
        {
            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public Customer getCustomer(String customer_id) {
        logger.debug("invocation get customer method");
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
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        logger.debug("invocation get customers method");
        List<Customer> customerList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers_table ORDER BY customer_firstname");
            ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                customerList.add(parseCustomer(resultSet));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return customerList;
    }

    @Override
    public void updateCustomer(String customer_id, Customer customer) {
        logger.debug("invocation update customer method");
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE customers_table SET customer_firstname=?, customer_lastname=?, customer_phonenumber=?, customer_email=? WHERE customer_id=?"))
        {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public void removeCustomer(String customer_id) {
        logger.debug("invocation remove customer method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM customers_table WHERE customer_id=?"))
        {
            preparedStatement.setString(1, customer_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    private Customer parseCustomer(ResultSet resultSet) {
        logger.debug("invocation parse customer method");
        Customer customer = null;
        try {
            String manager_id = resultSet.getString("customer_id");
            String firstname = resultSet.getString("customer_firstname");
            String lastname = resultSet.getString("customer_lastname");
            String phoneNumber = resultSet.getString("customer_phonenumber");
            String email = resultSet.getString("customer_email");
            customer = new Customer(manager_id, firstname, lastname, phoneNumber, email);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return customer;
    }
}
