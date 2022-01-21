package org.laba2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDAOFactory extends AbstractDAOFactory{

    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/practice12";
    public static final String USER = "laba2";
    public static final String PASSWORD = "laba2";

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Connected successfully ..." + connection.getTransactionIsolation());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public DAOOrder getDAOOrder() {
        return new PostgresDAOOrderImpl();
    }

    @Override
    public DAOTour getDAOTour() {
        return new PostgresDAOTourImpl();
    }

    @Override
    public DAOCustomer getDAOCustomer() {
        return new PostgresDAOCustomerImpl();
    }

    @Override
    public DAOManager getDAOManager() {
        return new PostgresDAOManagerImpl();
    }

    @Override
    public DAOTouroperator getDAOTouroperator() {
        return new PostgresDAOTouroperatorImpl();
    }

    @Override
    public DAOAccounting getDAOAccounting() {
        return new PostgresDAOAccountingImpl();
    }
}
