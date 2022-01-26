package org.laba2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@EnableWebMvc
@Configuration
@ComponentScan({"org.laba2"})
@PropertySource("classpath:dataSource.properties")
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Value("${database.driver}")
    private String driverClass;
    @Value("${database.dbUrl}")
    private String jdbcUrl;
    @Value("${database.user}")
    private String jdbcUserName;
    @Value("${database.password}")
    private String jdbcPassword;

    @Value("${dataSource.initialContextFactory}")
    private String initialContextFactory;
    @Value("${dataSource.providerHost}")
    private String providerHost;
    @Value("${dataSource.providerPort}")
    private String providerPort;
    @Value("${dataSource.dataSourceName}")
    private String dataSourceName;

    private final ApplicationContext applicationContext;

    @Autowired
    public AppConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

//    @Bean
//    public DataSource getWeblogicDataSource() {
//        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        return dsLookup.getDataSource(dataSourceName);
//    }

//    @Bean(destroyMethod = "")
//    public DataSource getWeblogicDataSource() {
//        Context context = null;
//        DataSource dataSource = null;
//        try {
//            context = new InitialContext();
//            dataSource = (DataSource)context.lookup("jdbc.DataSourceTravelCRM");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }

//    @Bean
//    public static DataSource getWeblogicDataSource() {
//        Hashtable<String, String> hashtable = new Hashtable<>();
//        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
//        hashtable.put(Context.PROVIDER_URL, "t3://" + "localhost" +":" + "7001");
//        Context context = null;
//        DataSource dataSource = null;
//        try {
//            context = new InitialContext(hashtable);
//            dataSource = (DataSource) context.lookup("DataSourceTravelCRM");
//        } catch (NamingException e) {
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
//        return dataSource;
//    }

    @Bean
    @Autowired
    DatabasePopulator databasePopulator(DataSource dataSource) throws SQLException, InterruptedException {
        DatabasePopulator dbp = new ResourceDatabasePopulator(false, false, "UTF-8",
                new ClassPathResource("postgresDBSchema.sql"));
        dbp.populate(DataSourceUtils.getConnection(dataSource));
        return dbp;
    }

}
