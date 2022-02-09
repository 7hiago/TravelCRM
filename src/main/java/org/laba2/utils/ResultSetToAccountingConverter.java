package org.laba2.utils;

import org.laba2.entities.Accounting;
import org.laba2.exception.DatabaseException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResultSetToAccountingConverter implements Converter<ResultSet, Accounting> {
    @Override
    public Accounting convert(ResultSet source) {
        Accounting accounting;
        try {
            String accounting_id = source.getString("accounting_id");
            float tour_price = source.getFloat("accounting_tour_price");
            float tour_paid = source.getFloat("accounting_tour_paid");
            float commissionPercent = source.getFloat("accounting_commissionpercent");
            float touroperator_price = source.getFloat("accounting_touroperator_price");
            float touroperator_paid = source.getFloat("accounting_touroperator_paid");
            float profit = source.getFloat("accounting_profit");
            accounting = new Accounting(accounting_id, tour_price, tour_paid, commissionPercent,
                    touroperator_price, touroperator_paid, profit);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database connection", e);
        }
        return accounting;
    }
}