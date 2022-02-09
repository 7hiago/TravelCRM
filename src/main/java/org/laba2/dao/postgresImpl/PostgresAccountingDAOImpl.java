package org.laba2.dao.postgresImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.dao.AccountingDAO;
import org.laba2.entities.Accounting;
import org.laba2.exception.DatabaseException;
import org.laba2.utils.ResultSetToAccountingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PostgresAccountingDAOImpl implements AccountingDAO {

    private static final Logger logger = LogManager.getLogger(PostgresAccountingDAOImpl.class);

    @Autowired
    private ResultSetToAccountingConverter resultSetToAccountingConverter;

    private final DataSource dataSource;

    public PostgresAccountingDAOImpl(DataSource dataSource) {
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
        Accounting accounting;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounting_table WHERE accounting_id=?")) {
            preparedStatement.setString(1, accounting_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            accounting = resultSetToAccountingConverter.convert(resultSet);
        } catch (SQLException e) {
            throw new DatabaseException("Something wrong happened with database connection", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("Problem with closing result set" + e.getMessage());
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
}