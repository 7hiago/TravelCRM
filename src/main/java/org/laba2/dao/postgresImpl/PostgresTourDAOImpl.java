package org.laba2.dao.postgresImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.dao.TourDAO;
import org.laba2.entities.Tour;
import org.laba2.exception.DatabaseException;
import org.laba2.utils.ResultSetToTourConverter;
import org.laba2.utils.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class PostgresTourDAOImpl implements TourDAO {

    private static final Logger logger = LogManager.getLogger(PostgresTourDAOImpl.class);

    @Autowired
    private StringToDateConverter stringToDateConverter;

    @Autowired
    private ResultSetToTourConverter resultSetToTourConverter;

    private final DataSource dataSource;

    public PostgresTourDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createTour(Tour tour) {
        logger.debug("invocation create tour method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tours_table (tour_id, tour_country, tour_hotel, tour_departuredate, tour_returndate, tour_proposal, touroperator_id) VALUES (?,?,?,?,?,?,?)"))
        {
            preparedStatement.setString(1, tour.getTourId());
            preparedStatement.setString(2, tour.getCountry());
            preparedStatement.setString(3, tour.getHotel());
            preparedStatement.setDate(4, stringToDateConverter.convert(tour.getDepartureDate()));
            preparedStatement.setDate(5, stringToDateConverter.convert(tour.getReturnDate()));
            preparedStatement.setString(6, tour.getProposalNumber());
            preparedStatement.setString(7, tour.getTouroperatorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public Tour getTour(String tour_id) {
        logger.debug("invocation get tour method");
        Tour tour;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tours_table WHERE tour_id=?"))
        {
            preparedStatement.setString(1, tour_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            tour = resultSetToTourConverter.convert(resultSet);
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
        return tour;
    }

    @Override
    public void updateTour(String tour_id, Tour tour) {
        logger.debug("invocation update tour method");
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE tours_table SET tour_country=?, tour_hotel=?, tour_departuredate=?, tour_returndate=?, tour_proposal=?, touroperator_id=? WHERE tour_id=?"))
        {
            preparedStatement.setString(1, tour.getCountry());
            preparedStatement.setString(2, tour.getHotel());
            preparedStatement.setDate(3, stringToDateConverter.convert(tour.getDepartureDate()));
            preparedStatement.setDate(4, stringToDateConverter.convert(tour.getReturnDate()));
            preparedStatement.setString(5, tour.getProposalNumber());
            preparedStatement.setString(6, tour.getTouroperatorId());
            preparedStatement.setString(7, tour_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }

    @Override
    public void removeTour(String tour_id) {
        logger.debug("invocation remove tour method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM tours_table WHERE tour_id=?"))
        {
            preparedStatement.setString(1, tour_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
    }
}