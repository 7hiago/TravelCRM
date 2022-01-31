package org.laba2.dao.postgresImpl;

import org.apache.log4j.Logger;
import org.laba2.dao.AccountingDAO;
import org.laba2.entities.Accounting;
import org.laba2.exception.DatabaseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@DependsOn("datasource")
public class PostgresAccountingDAOImpl implements AccountingDAO {

    private static final Logger logger = Logger.getLogger(PostgresAccountingDAOImpl.class);

    private final DataSource dataSource;

    public PostgresAccountingDAOImpl(@Qualifier("datasource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createAccounting(Accounting accounting) {
        logger.debug("invocation create accounting method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accounting_table (accounting_id, accounting_tour_price, accounting_tour_paid, accounting_commissionpercent, accounting_touroperator_price, accounting_touroperator_paid, accounting_profit) VALUES (?,?,?,?,?,?,?)")) {
            preparedStatement.setString(1, accounting.getAccountingId());
            preparedStatement.setFloat(2, accounting.getTourPrice());
            preparedStatement.setFloat(3, accounting.getTourPaid());
            preparedStatement.setFloat(4, accounting.getCommission());
            preparedStatement.setFloat(5, accounting.getTouroperatorPrice());
            preparedStatement.setFloat(6, accounting.getTouroperatorPaid());
            preparedStatement.setFloat(7, accounting.getProfit());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database connection", e);
        }
    }

    @Override
    public Accounting getAccounting(String accounting_id) {
        logger.debug("invocation get accounting method");
        Accounting accounting = null;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounting_table WHERE accounting_id=?")) {
            preparedStatement.setString(1, accounting_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            accounting = parseAccounting(resultSet);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database connection", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return accounting;
    }

    @Override
    public void updateAccounting(String accounting_id, Accounting accounting) {
        logger.debug("invocation update accounting method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE accounting_table SET accounting_tour_price=?, accounting_tour_paid=?, accounting_commissionpercent=?, accounting_touroperator_price=?, accounting_touroperator_paid=?, accounting_profit=? WHERE accounting_id=?")) {
            preparedStatement.setFloat(1, accounting.getTourPrice());
            preparedStatement.setFloat(2, accounting.getTourPaid());
            preparedStatement.setFloat(3, accounting.getCommission());
            preparedStatement.setFloat(4, accounting.getTouroperatorPrice());
            preparedStatement.setFloat(5, accounting.getTouroperatorPaid());
            preparedStatement.setFloat(6, accounting.getProfit());
            preparedStatement.setString(7, accounting.getAccountingId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database connection", e);
        }
    }

    @Override
    public void removeAccounting(String accounting_id) {
        logger.debug("invocation remove accounting method");
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM accounting_table WHERE accounting_id=?")) {
            preparedStatement.setString(1, accounting_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database connection", e);
        }
    }

    private Accounting parseAccounting(ResultSet resultSet) {
        logger.debug("invocation parse accounting method");
        Accounting accounting = null;
        try {
            String accounting_id = resultSet.getString("accounting_id");
            float tour_price = resultSet.getFloat("accounting_tour_price");
            float tour_paid = resultSet.getFloat("accounting_tour_paid");
            float commissionPercent = resultSet.getFloat("accounting_commissionpercent");
            float touroperator_price = resultSet.getFloat("accounting_touroperator_price");
            float touroperator_paid = resultSet.getFloat("accounting_touroperator_paid");
            float profit = resultSet.getFloat("accounting_profit");
            accounting = new Accounting(accounting_id, tour_price, tour_paid, commissionPercent,
                    touroperator_price, touroperator_paid, profit);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database connection", e);
        }
        return accounting;
    }
}
