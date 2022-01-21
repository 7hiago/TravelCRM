package org.laba2.dao;

public abstract class AbstractDAOFactory {

    public abstract DAOOrder getDAOOrder();
    public abstract DAOTour getDAOTour();
    public abstract DAOCustomer getDAOCustomer();
    public abstract DAOManager getDAOManager();
    public abstract DAOTouroperator getDAOTouroperator();
    public abstract DAOAccounting getDAOAccounting();

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
