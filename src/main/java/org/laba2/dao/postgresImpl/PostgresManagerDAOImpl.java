package org.laba2.dao.postgresImpl;

import org.laba2.dao.ManagerDAO;
import org.laba2.entities.Manager;
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
public class PostgresManagerDAOImpl implements ManagerDAO {

    private final DataSource dataSource;

    public PostgresManagerDAOImpl(@Qualifier("datasource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createManager(Manager manager) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO managers_table (manager_id, manager_firstname, manager_lastname, manager_salary, manager_hiredate, manager_phonenumber, manager_email, manager_login, manager_password, manager_role, manager_status) VALUES (?,?,?,?,?,?,?,?,?,?,?)"))
        {
            preparedStatement.setString(1, manager.getManagerId());
            preparedStatement.setString(2, manager.getFirstName());
            preparedStatement.setString(3, manager.getLastName());
            preparedStatement.setFloat(4, manager.getSalary());
            preparedStatement.setDate(5, Date.valueOf(manager.getHireDate()));
            preparedStatement.setString(6, manager.getPhoneNumber());
            preparedStatement.setString(7, manager.getEmail());
            preparedStatement.setString(8, manager.getLogin());
            preparedStatement.setString(9, manager.getPassword());
            preparedStatement.setString(10, manager.getRole());
            preparedStatement.setString(11, manager.getStatus());
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item manager already exist");
            else System.out.println("Manager added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Manager getManagerByLogin(String manager_login) {
        Manager manager = null;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM managers_table WHERE manager_login=?"))
        {
            preparedStatement.setString(1, manager_login);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            manager = parseManager(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try { resultSet.close();} catch (SQLException e) { e.printStackTrace();}
            }
        }
        return manager;
    }

    @Override
    public Manager getManagerById(String manager_id) {
        Manager manager = null;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM managers_table WHERE manager_id=?"))
        {
            preparedStatement.setString(1, manager_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            manager = parseManager(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try { resultSet.close();} catch (SQLException e) { e.printStackTrace();}
            }
        }
        return manager;
    }

    @Override
    public List<Manager> getManagers() {
        List<Manager> managerList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM managers_table ORDER BY manager_id");
            ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                managerList.add(parseManager(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managerList;
    }

    @Override
    public void updateManager(String manager_id, Manager manager) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE managers_table SET manager_firstname=?, manager_lastname=?, manager_salary=?, manager_hiredate=?, manager_phonenumber=?, manager_email=?, manager_login=?, manager_password=?, manager_role=?, manager_status=? WHERE manager_id=?"))
        {
            preparedStatement.setString(1, manager.getFirstName());
            preparedStatement.setString(2, manager.getLastName());
            preparedStatement.setFloat(3, manager.getSalary());
            preparedStatement.setDate(4, Date.valueOf(manager.getHireDate()));
            preparedStatement.setString(5, manager.getPhoneNumber());
            preparedStatement.setString(6, manager.getEmail());
            preparedStatement.setString(7, manager.getLogin());
            preparedStatement.setString(8, manager.getPassword());
            preparedStatement.setString(9, manager.getRole());
            preparedStatement.setString(10, manager.getStatus());
            preparedStatement.setString(11, manager_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item manager not exist");
            System.out.println("Manager updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeManager(String manager_id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM managers_table WHERE manager_id=?"))
        {
            preparedStatement.setString(1, manager_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item manager not exist");
            else System.out.println("Manager deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Manager parseManager(ResultSet resultSet) {
        Manager manager = null;
        try {
            String manager_id = resultSet.getString("manager_id");
            String firstname = resultSet.getString("manager_firstname");
            String lastname = resultSet.getString("manager_lastname");
            float salary = resultSet.getFloat("manager_salary");
            String hireDate = resultSet.getString("manager_hiredate");
            String phoneNumber = resultSet.getString("manager_phonenumber");
            String email = resultSet.getString("manager_email");
            String login = resultSet.getString("manager_login");
            String password = resultSet.getString("manager_password");
            String role = resultSet.getString("manager_role");
            String status = resultSet.getString("manager_status");
            manager = new Manager(manager_id, firstname, lastname,
                    salary, hireDate, phoneNumber, email, login, password, role, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }
}
