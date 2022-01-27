package org.laba2.dao.postgresImpl;

import org.laba2.dao.TouroperatorDAO;
import org.laba2.entities.Touroperator;
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
public class PostgresTouroperatorDAOImpl implements TouroperatorDAO {

    private final DataSource dataSource;

    public PostgresTouroperatorDAOImpl(@Qualifier("datasource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createTouroperator(Touroperator touroperator) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO touroperators_table (touroperator_id, touroperator_name, touroperator_phonenumber, touroperator_email) VALUES (?,?,?,?)"))
        {
            preparedStatement.setString(1, touroperator.getTouroperatorId());
            preparedStatement.setString(2, touroperator.getName());
            preparedStatement.setString(3, touroperator.getPhoneNumber());
            preparedStatement.setString(4, touroperator.getEmail());
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item already exist");
            else System.out.println("Added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Touroperator getTouroperator(String touroperator_id) {
        Touroperator touroperator = null;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM touroperators_table WHERE touroperator_id=?"))
        {
            preparedStatement.setString(1, touroperator_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            touroperator = parseTouroperator(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try { resultSet.close();} catch (SQLException e) { e.printStackTrace();}
            }
        }
        return touroperator;
    }

    @Override
    public List<Touroperator> getTouroperators() {
        List<Touroperator> touroperatorList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM touroperators_table ORDER BY touroperator_id");
            ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                touroperatorList.add(parseTouroperator(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return touroperatorList;
    }

    @Override
    public void updateTouroperator(String touroperator_id, Touroperator touroperator) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE touroperators_table SET touroperator_name=?, touroperator_phonenumber=?, touroperator_email=? WHERE touroperator_id=?"))
        {
            preparedStatement.setString(1, touroperator.getName());
            preparedStatement.setString(2, touroperator.getPhoneNumber());
            preparedStatement.setString(3, touroperator.getEmail());
            preparedStatement.setString(4, touroperator.getTouroperatorId());

            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item not exist");
            System.out.println("Job updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTouroperator(String touroperator_id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM touroperators_table WHERE touroperator_id=?"))
        {
            preparedStatement.setString(1, touroperator_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item not exist");
            else System.out.println("Deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Touroperator parseTouroperator(ResultSet resultSet) {
        Touroperator touroperator = null;
        try {
            String touroperator_id = resultSet.getString("touroperator_id");
            String touroperator_name = resultSet.getString("touroperator_name");
            String touroperator_phonenumber = resultSet.getString("touroperator_phonenumber");
            String touroperator_email = resultSet.getString("touroperator_email");

            touroperator = new Touroperator(touroperator_id, touroperator_name, touroperator_phonenumber, touroperator_email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return touroperator;
    }
}
