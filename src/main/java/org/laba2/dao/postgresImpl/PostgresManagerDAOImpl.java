package org.laba2.dao.postgresImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.dao.ManagerDAO;
import org.laba2.entities.Manager;
import org.laba2.exception.DatabaseException;
import org.laba2.utils.StringToDateConverter;
import org.laba2.utils.ResultSetToManagerConverter;
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
public class PostgresManagerDAOImpl implements ManagerDAO {

    private static final Logger logger = LogManager.getLogger(PostgresManagerDAOImpl.class);

    @Autowired
    private StringToDateConverter stringToDateConverter;

    @Autowired
    private ResultSetToManagerConverter resultSetToManagerConverter;

    private final DataSource dataSource;

    public PostgresManagerDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createManager(Manager manager) {
        logger.debug("invocation create manager method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO managers_table (manager_id, manager_firstname, manager_lastname, manager_salary, manager_hiredate, manager_phonenumber, manager_email, manager_login, manager_password, manager_role, manager_status) VALUES (?,?,?,?,?,?,?,?,?,?,?)")) {
            preparedStatement.setString(1, manager.getManagerId());
            preparedStatement.setString(2, manager.getFirstName());
            preparedStatement.setString(3, manager.getLastName());
            preparedStatement.setFloat(4, manager.getSalary());
            preparedStatement.setDate(5, stringToDateConverter.convert(manager.getHireDate()));
            preparedStatement.setString(6, manager.getPhoneNumber());
            preparedStatement.setString(7, manager.getEmail());
            preparedStatement.setString(8, manager.getLogin());
            preparedStatement.setString(9, manager.getPassword());
            preparedStatement.setString(10, manager.getRole());
            preparedStatement.setString(11, manager.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public Manager getManagerByLogin(String manager_login) {
        logger.debug("invocation get manager by login method");
        Manager manager;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM managers_table WHERE manager_login=?")) {
            preparedStatement.setString(1, manager_login);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            manager = resultSetToManagerConverter.convert(resultSet);
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
        return manager;
    }

    @Override
    public Manager getManagerById(String manager_id) {
        logger.debug("invocation get manager by id method");
        Manager manager;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM managers_table WHERE manager_id=?")) {
            preparedStatement.setString(1, manager_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            manager = resultSetToManagerConverter.convert(resultSet);
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
        return manager;
    }

    @Override
    public List<Manager> getManagers() {
        logger.debug("invocation get managers method");
        List<Manager> managerList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM managers_table ORDER BY manager_id");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                managerList.add(resultSetToManagerConverter.convert(resultSet));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return managerList;
    }

    @Override
    public void updateManager(String manager_id, Manager manager) {
        logger.debug("invocation update manager method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE managers_table SET manager_firstname=?, manager_lastname=?, manager_salary=?, manager_hiredate=?, manager_phonenumber=?, manager_email=?, manager_login=?, manager_password=?, manager_role=?, manager_status=? WHERE manager_id=?")) {
            preparedStatement.setString(1, manager.getFirstName());
            preparedStatement.setString(2, manager.getLastName());
            preparedStatement.setFloat(3, manager.getSalary());
            preparedStatement.setDate(4, stringToDateConverter.convert(manager.getHireDate()));
            preparedStatement.setString(5, manager.getPhoneNumber());
            preparedStatement.setString(6, manager.getEmail());
            preparedStatement.setString(7, manager.getLogin());
            preparedStatement.setString(8, manager.getPassword());
            preparedStatement.setString(9, manager.getRole());
            preparedStatement.setString(10, manager.getStatus());
            preparedStatement.setString(11, manager_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public void removeManager(String manager_id) {
        logger.debug("invocation remove manager method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM managers_table WHERE manager_id=?")) {
            preparedStatement.setString(1, manager_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }
}