package org.laba2.dao.postgres;

import org.laba2.dao.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

@Component
public class PostgresDAOFactory extends AbstractDAOFactory {

//    -------------------------- Weblogic ----------------------------------------------------------
//    DataSourceTravelCRM
//    private static String initialContextFactoryStatic; //weblogic.jndi.WLInitialContextFactory
//    private static String providerPortStatic; //localhost
//    private static String providerHostStatic; //7001
//    private static String dataSourceNameStatic; //DataSourceTravelCRM
//
//    @Value("${dataSource.initialContextFactory}")
//    private String initialContextFactory;
//
//    @Value("${dataSource.initialContextFactory}")
//    public void setInitialContextFactory(String initialContextFactory) {
//        initialContextFactoryStatic = initialContextFactory;
//        System.out.println("Not static initialContextFactory:" + initialContextFactory);
//    }
//
//    @Value("${dataSource.providerHost}")
//    private String providerPort;
//
//    @Value("${dataSource.providerPort}")
//    public void setProviderPort(String providerPort) {
//        providerPortStatic = providerPort;
//        System.out.println("Not static providerPort:" + providerPort);
//    }
//
//    @Value("${dataSource.providerPort}")
//    private String providerHost;
//
//    @Value("${dataSource.providerHost}")
//    public void setProviderHost(String providerHost) {
//        providerHostStatic = providerHost;
//        System.out.println("Not static providerHost:" + providerHost);
//    }
//
//    @Value("${dataSource.dataSourceName}")
//    private String dataSourceName;
//
//    @Value("${dataSource.dataSourceName}")
//    public void setDataSourceName(String dataSourceName) {
//        dataSourceNameStatic = dataSourceName;
//        System.out.println("Not static dataSourceName:" + dataSourceName);
//    }
//
//    public static Connection createConnection() {
//        Hashtable<String, String> hashtable = new Hashtable<>();
//        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, initialContextFactoryStatic);
//        hashtable.put(Context.PROVIDER_URL, "t3://" + providerHostStatic +":" + providerPortStatic);
//        Context context = null;
//        Connection connection = null;
//
//        try {
//            context = new InitialContext(hashtable);
//            DataSource dataSource = (DataSource) context.lookup(dataSourceNameStatic);
//            connection = dataSource.getConnection();
//            if(!connection.isClosed()){
//                System.out.println("Connected successfully ..." + connection.getTransactionIsolation());
//            }
//        } catch (SQLException | NamingException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(context != null) {
//                    context.close();
//                }
//            } catch (NamingException e) {
//                e.printStackTrace();
//            }
//        }
//        return connection;
//    }

//    -------------------------- Tomcat ----------------------------------------------------------
    private static String driver = "org.postgresql.Driver";
    private static String dbUrl = "jdbc:postgresql://localhost:5432/TravelCRMDatabase";
    private static String user = "TravelCRMadmin";
    private static String password = "TravelCRMadmin";

    public static Connection createConnection() {
        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dbUrl, user, password);
            if(!connection.isClosed()){
                System.out.println("Connected successfully ..." + connection.getTransactionIsolation());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public OrderDAO getDAOOrder() {
        return new PostgresOrderDAOImpl();
    }

    @Override
    public TourDAO getDAOTour() {
        return new PostgresTourDAOImpl();
    }

    @Override
    public CustomerDAO getDAOCustomer() {
        return new PostgresCustomerDAOImpl();
    }

    @Override
    public ManagerDAO getDAOManager() {
        return new PostgresManagerDAOImpl();
    }

    @Override
    public TouroperatorDAO getDAOTouroperator() {
        return new PostgresTouroperatorDAOImpl();
    }

    @Override
    public AccountingDAO getDAOAccounting() {
        return new PostgresAccountingDAOImpl();
    }
}
