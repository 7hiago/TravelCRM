package org.laba2.dao.postgres;

import org.laba2.dao.AccountingDAO;
import org.laba2.entities.Accounting;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class PostgresAccountingDAOImpl implements AccountingDAO {
    @Override
    public void createAccounting(Accounting accounting) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accounting_table (accounting_tour_price, accounting_tour_paid, accounting_commissionpercent, accounting_touroperator_price, accounting_touroperator_paid, accounting_profit) VALUES (?,?,?,?,?,?)"))
        {
            preparedStatement.setFloat(1, accounting.getTourPrice());
            preparedStatement.setFloat(2, accounting.getTourPaid());
            preparedStatement.setFloat(3, accounting.getCommission());
            preparedStatement.setFloat(4, accounting.getTouroperatorPrice());
            preparedStatement.setFloat(5, accounting.getTouroperatorPaid());
            preparedStatement.setFloat(6, accounting.getProfit());
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item accounting already exist");
            else System.out.println("Accounting added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Accounting getAccounting(int accounting_id) {
        Accounting accounting = null;
        ResultSet resultSet = null;
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accounting_table WHERE accounting_id=?"))
        {
            preparedStatement.setInt(1, accounting_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            accounting = parseAccounting(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try { resultSet.close();} catch (SQLException e) { e.printStackTrace();}
            }
        }
        return accounting;
    }

    @Override
    public void updateAccounting(int accounting_id, Accounting accounting) {
        try(Connection connection = PostgresDAOFactory.createConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE accounting_table SET accounting_tour_price=?, accounting_tour_paid=?, accounting_commissionpercent=?, accounting_touroperator_price=?, accounting_touroperator_paid=?, accounting_profit=? WHERE accounting_id=?"))
        {
            preparedStatement.setFloat(1, accounting.getTourPrice());
            preparedStatement.setFloat(2, accounting.getTourPaid());
            preparedStatement.setFloat(3, accounting.getCommission());
            preparedStatement.setFloat(4, accounting.getTouroperatorPrice());
            preparedStatement.setFloat(5, accounting.getTouroperatorPaid());
            preparedStatement.setFloat(6, accounting.getProfit());
            preparedStatement.setInt(7, accounting.getAccountingId());

            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item accounting not exist");
            System.out.println("Accounting updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAccounting(int accounting_id) {
        try (Connection connection = PostgresDAOFactory.createConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM accounting_table WHERE accounting_id=?"))
        {
            preparedStatement.setInt(1, accounting_id);
            int num = preparedStatement.executeUpdate();
            if(num == 0) System.out.println("Item accounting not exist");
            else System.out.println("Accounting deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Accounting parseAccounting(ResultSet resultSet) {
        Accounting accounting = null;
        try {
            int accounting_id = resultSet.getInt("accounting_id");
            float tour_price = resultSet.getFloat("accounting_tour_price");
            float tour_paid = resultSet.getFloat("accounting_tour_paid");
            float commissionPercent = resultSet.getFloat("accounting_commissionpercent");
            float touroperator_price = resultSet.getFloat("accounting_touroperator_price");
            float touroperator_paid = resultSet.getFloat("accounting_touroperator_paid");
            float profit = resultSet.getFloat("accounting_profit");
            accounting = new Accounting(accounting_id, tour_price, tour_paid, commissionPercent,
                    touroperator_price, touroperator_paid, profit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounting;
    }
}
