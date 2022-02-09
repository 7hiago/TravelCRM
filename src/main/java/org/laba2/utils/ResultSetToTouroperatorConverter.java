package org.laba2.utils;

import org.laba2.entities.Touroperator;
import org.laba2.exception.DatabaseException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResultSetToTouroperatorConverter implements Converter<ResultSet, Touroperator> {
    @Override
    public Touroperator convert(ResultSet source) {
        Touroperator touroperator;
        try {
            String touroperator_id = source.getString("touroperator_id");
            String touroperator_name = source.getString("touroperator_name");
            String touroperator_phonenumber = source.getString("touroperator_phonenumber");
            String touroperator_email = source.getString("touroperator_email");

            touroperator = new Touroperator(touroperator_id, touroperator_name, touroperator_phonenumber, touroperator_email);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database", e);
        }
        return touroperator;
    }
}