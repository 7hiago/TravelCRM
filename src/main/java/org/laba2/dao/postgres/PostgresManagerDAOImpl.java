package org.laba2.dao.postgres;

import org.laba2.dao.ManagerDAO;
import org.laba2.entities.Manager;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresManagerDAOImpl implements ManagerDAO {

    @Override
    public void createManager(Manager manager) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO managers_table (manager_firstname, manager_lastname, manager_salary, manager_hiredate, manager_phonenumber, manager_email, manager_login, manager_password) VALUES (?,?,?,?,?,?,?,?)"))
        {
            preparedStatement.setString(1, manager.getFirstName());
            preparedStatement.setString(2, manager.getLastName());
            preparedStatement.setFloat(3, manager.getSalary());
            preparedStatement.setDate(4, Date.valueOf(manager.getHireDate()));
            preparedStatement.setString(5, manager.getPhoneNumber());
            preparedStatement.setString(6, manager.getEmail());
            preparedStatement.setString(7, manager.getLogin());
            preparedStatement.setString(8, manager.getPassword());
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item manager already exist");
            else System.out.println("Manager added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Manager getManager(int manager_id) {
        Manager manager = null;
        ResultSet resultSet = null;
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM managers_table WHERE manager_id=?"))
        {
            preparedStatement.setInt(1, manager_id);
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
        try(Connection connection = PostgresDAOFactory.createConnection();
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
    public void updateManager(int manager_id, Manager manager) {
        try(Connection connection = PostgresDAOFactory.createConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE managers_table SET manager_firstname=?, manager_lastname=?, manager_salary=?, manager_hiredate=?, manager_phonenumber=?, manager_email=?, manager_login=?, manager_password=? WHERE manager_id=?"))
        {
            preparedStatement.setString(1, manager.getFirstName());
            preparedStatement.setString(2, manager.getLastName());
            preparedStatement.setFloat(3, manager.getSalary());
            preparedStatement.setDate(4, Date.valueOf(manager.getHireDate()));
            preparedStatement.setString(5, manager.getPhoneNumber());
            preparedStatement.setString(6, manager.getEmail());
            preparedStatement.setString(7, manager.getLogin());
            preparedStatement.setString(8, manager.getPassword());
            preparedStatement.setInt(9, manager_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item manager not exist");
            System.out.println("Manager updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeManager(int manager_id) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM managers_table WHERE manager_id=?"))
        {
            preparedStatement.setInt(1, manager_id);
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
            int manager_id = resultSet.getInt("manager_id");
            String firstname = resultSet.getString("manager_firstname");
            String lastname = resultSet.getString("manager_lastname");
            float salary = resultSet.getFloat("manager_salary");
            String hireDate = resultSet.getString("manager_hiredate");
            String phoneNumber = resultSet.getString("manager_phonenumber");
            String email = resultSet.getString("manager_email");
            String login = resultSet.getString("manager_login");
            String password = resultSet.getString("manager_password");
            manager = new Manager(manager_id, firstname, lastname,
                    salary, hireDate, phoneNumber, email, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }
}
