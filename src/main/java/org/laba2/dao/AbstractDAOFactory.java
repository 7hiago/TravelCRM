package org.laba2.dao;

import org.laba2.dao.postgres.PostgresDAOFactory;

public abstract class AbstractDAOFactory {

    public abstract OrderDAO getDAOOrder();
    public abstract TourDAO getDAOTour();
    public abstract CustomerDAO getDAOCustomer();
    public abstract ManagerDAO getDAOManager();
    public abstract TouroperatorDAO getDAOTouroperator();
    public abstract AccountingDAO getDAOAccounting();

    public static PostgresDAOFactory getDAOFactory(DBType dbType) {
        switch (dbType) {
            case POSTGRESQL:
                return new PostgresDAOFactory();
            case ORACLE :
                return null;
            default:
                return null;
        }
    }
}
