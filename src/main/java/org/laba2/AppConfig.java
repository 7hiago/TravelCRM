package org.laba2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Hashtable;

@EnableWebMvc
@Configuration
@ComponentScan({"org.laba2"})
@PropertySource("classpath:dataSource.properties")
public class AppConfig {

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

    @Value("${tomcat.dataSource.driver}")
    private String driverClass;
    @Value("${tomcat.dataSource.dbUrl}")
    private String jdbcUrl;
    @Value("${tomcat.dataSource.user}")
    private String jdbcUserName;
    @Value("${tomcat.dataSource.password}")
    private String jdbcPassword;

    @Value("${weblogic.datasource.initialContextFactory}")
    private String initialContextFactory;
    @Value("${weblogic.datasource.providerHost}")
    private String providerHost;
    @Value("${weblogic.datasource.providerPort}")
    private String providerPort;
    @Value("${weblogic.datasource.dataSourceName}")
    private String dataSourceName;

    @Bean(name = "datasource") // "tomcat"
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

    @Bean(name = "weblogic", destroyMethod = "") // "weblogic"
    public DataSource getWeblogicDataSource() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, initialContextFactory);
        hashtable.put(Context.PROVIDER_URL, "t3://" + providerHost + ":" + providerPort);
        Context context = null;
        DataSource dataSource = null;
        try {
            context = new InitialContext(hashtable);
            dataSource = (DataSource) context.lookup(dataSourceName);
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if(context != null) {
                    context.close();
                }
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    @Bean
    DatabasePopulator databasePopulator(@Qualifier("datasource") DataSource dataSource) throws SQLException {
        DatabasePopulator dbp = new ResourceDatabasePopulator(false, false, "UTF-8",
                new ClassPathResource("postgresDBSchema.sql"));
        dbp.populate(DataSourceUtils.getConnection(dataSource));
        return dbp;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
