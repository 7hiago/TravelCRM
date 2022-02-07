package org.laba2.dao.postgresImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.dao.TouroperatorDAO;
import org.laba2.entities.Touroperator;
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
public class PostgresTouroperatorDAOImpl implements TouroperatorDAO {

    private static final Logger logger = LogManager.getLogger(PostgresTouroperatorDAOImpl.class);

    private final DataSource dataSource;

    public PostgresTouroperatorDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createTouroperator(Touroperator touroperator) {
        logger.debug("invocation create touroperator method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO touroperators_table (touroperator_id, touroperator_name, touroperator_phonenumber, touroperator_email) VALUES (?,?,?,?)"))
        {
            preparedStatement.setString(1, touroperator.getTouroperatorId());
            preparedStatement.setString(2, touroperator.getName());
            preparedStatement.setString(3, touroperator.getPhoneNumber());
            preparedStatement.setString(4, touroperator.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public Touroperator getTouroperator(String touroperator_id) {
        logger.debug("invocation get touroperator method");
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
        return touroperator;
    }

    @Override
    public List<Touroperator> getTouroperators() {
        logger.debug("invocation get touroperators method");
        List<Touroperator> touroperatorList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM touroperators_table ORDER BY touroperator_id");
            ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                touroperatorList.add(parseTouroperator(resultSet));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return touroperatorList;
    }

    @Override
    public void updateTouroperator(String touroperator_id, Touroperator touroperator) {
        logger.debug("invocation update touroperator method");
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE touroperators_table SET touroperator_name=?, touroperator_phonenumber=?, touroperator_email=? WHERE touroperator_id=?"))
        {
            preparedStatement.setString(1, touroperator.getName());
            preparedStatement.setString(2, touroperator.getPhoneNumber());
            preparedStatement.setString(3, touroperator.getEmail());
            preparedStatement.setString(4, touroperator.getTouroperatorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public void removeTouroperator(String touroperator_id) {
        logger.debug("invocation remove touroperator method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM touroperators_table WHERE touroperator_id=?"))
        {
            preparedStatement.setString(1, touroperator_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    private Touroperator parseTouroperator(ResultSet resultSet) {
        logger.debug("invocation parse touroperator method");
        Touroperator touroperator = null;
        try {
            String touroperator_id = resultSet.getString("touroperator_id");
            String touroperator_name = resultSet.getString("touroperator_name");
            String touroperator_phonenumber = resultSet.getString("touroperator_phonenumber");
            String touroperator_email = resultSet.getString("touroperator_email");

            touroperator = new Touroperator(touroperator_id, touroperator_name, touroperator_phonenumber, touroperator_email);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return touroperator;
    }
}
