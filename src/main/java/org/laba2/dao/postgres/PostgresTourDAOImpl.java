package org.laba2.dao.postgres;

import org.laba2.dao.TourDAO;
import org.laba2.entities.Tour;

import java.sql.*;

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
            if(num == 0) System.out.println("Item already exist");
            else System.out.println("Added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tour getTour(int tour_id) {
        Tour tour = null;
        ResultSet resultSet = null;
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tours_table WHERE tour_id=?"))
        {
            preparedStatement.setInt(1, tour_id);
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
    public void updateTour(int tour_id, Tour tour) {
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
            preparedStatement.setInt(7, tour.getTourId());

            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item not exist");
            System.out.println("Tour updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTour(int tour_id) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM tours_table WHERE tour_id=?"))
        {
            preparedStatement.setInt(1, tour_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item not exist");
            else System.out.println("Deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Tour parseTour(ResultSet resultSet) {
        Tour tour = null;
        try {
            int tour_id = resultSet.getInt("tour_id");
            String tour_country = resultSet.getString("tour_country");
            String tour_hotel = resultSet.getString("tour_hotel");
            String tour_departuredate = resultSet.getString("tour_departuredate");
            String tour_returndate = resultSet.getString("tour_returndate");
            String  tour_proposal = resultSet.getString("tour_proposal");
            int  touroperator_id = resultSet.getInt("touroperator_id");
            tour = new Tour(tour_id, tour_country, tour_hotel, tour_departuredate,
                    tour_returndate, tour_proposal, touroperator_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tour;
    }

}
