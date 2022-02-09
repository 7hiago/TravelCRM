package org.laba2.utils;

import org.laba2.entities.Tour;
import org.laba2.exception.DatabaseException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResultSetToTourConverter implements Converter<ResultSet, Tour> {
    @Override
    public Tour convert(ResultSet source) {
        Tour tour;
        try {
            String tour_id = source.getString("tour_id");
            String country = source.getString("tour_country");
            String hotel = source.getString("tour_hotel");
            String departureDate = source.getString("tour_departuredate");
            String returnDate = source.getString("tour_returndate");
            String proposal = source.getString("tour_proposal");
            String touroperator_id = source.getString("touroperator_id");
            tour = new Tour(tour_id, country, hotel, departureDate,
                    returnDate, proposal, touroperator_id);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return tour;
    }
}