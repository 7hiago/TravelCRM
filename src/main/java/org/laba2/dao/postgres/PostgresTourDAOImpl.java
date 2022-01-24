package org.laba2.dao.postgres;

import org.laba2.dao.TourDAO;
import org.laba2.entities.Tour;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class PostgresTourDAOImpl implements TourDAO {

    @Override
    public void createTour(Tour tour) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tours_table (tour_country, tour_hotel, tour_departuredate, tour_returndate, tour_proposal, touroperator_id) VALUES (?,?,?,?,?,?)"))
        {
            preparedStatement.setString(1, tour.getCountry());
            preparedStatement.setString(2, tour.getHotel());
            preparedStatement.setDate(3, Date.valueOf(tour.getDepartureDate()));
            preparedStatement.setDate(4, Date.valueOf(tour.getReturnDate()));
            preparedStatement.setString(5, tour.getProposalNumber());
            preparedStatement.setInt(6, tour.getTouroperatorId());
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item tour already exist");
            else System.out.println("Tour added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tour getTour(String tour_id) {
        Tour tour = null;
        ResultSet resultSet = null;
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tours_table WHERE tour_id=?"))
        {
            preparedStatement.setInt(1, Integer.parseInt(tour_id));
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            tour = parseTour(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try { resultSet.close();} catch (SQLException e) { e.printStackTrace();}
            }
        }
        return tour;
    }

    @Override
    public void updateTour(String tour_id, Tour tour) {
        try(Connection connection = PostgresDAOFactory.createConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE tours_table SET tour_country=?, tour_hotel=?, tour_departuredate=?, tour_returndate=?, tour_proposal=?, touroperator_id=? WHERE tour_id=?"))
        {
            preparedStatement.setString(1, tour.getCountry());
            preparedStatement.setString(2, tour.getHotel());
            preparedStatement.setDate(3, Date.valueOf(tour.getDepartureDate()));
            preparedStatement.setDate(4, Date.valueOf(tour.getReturnDate()));
            preparedStatement.setString(5, tour.getProposalNumber());
            preparedStatement.setInt(6, tour.getTouroperatorId());
            preparedStatement.setInt(7, Integer.parseInt(tour_id));

            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item tour not exist");
            System.out.println("Tour updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTour(String tour_id) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM tours_table WHERE tour_id=?"))
        {
            preparedStatement.setInt(1, Integer.parseInt(tour_id));
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item tour not exist");
            else System.out.println("Tour deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Tour parseTour(ResultSet resultSet) {
        Tour tour = null;
        try {
            String tour_id = String.valueOf(resultSet.getInt("tour_id"));
            String country = resultSet.getString("tour_country");
            String hotel = resultSet.getString("tour_hotel");
            String departureDate = resultSet.getString("tour_departuredate");
            String returnDate = resultSet.getString("tour_returndate");
            String proposal = resultSet.getString("tour_proposal");
            int touroperator_id = resultSet.getInt("touroperator_id");
            tour = new Tour(tour_id, country, hotel, departureDate,
                    returnDate, proposal, touroperator_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tour;
    }
}
