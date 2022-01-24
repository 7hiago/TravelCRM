package org.laba2;

import org.laba2.dao.*;
import org.laba2.dao.postgres.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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

    @Bean
    public OrderDAO orderDAO(){
        return new PostgresOrderDAOImpl();
    }

    @Bean
    public TouroperatorDAO touroperatorDAO(){
        return new PostgresTouroperatorDAOImpl();
    }

    @Bean
    public AccountingDAO accountingDAO(){
        return new PostgresAccountingDAOImpl();
    }

    @Bean
    public ManagerDAO managerDAO(){
        return new PostgresManagerDAOImpl();
    }

    @Bean
    public CustomerDAO customerDAO(){
        return new PostgresCustomerDAOImpl();
    }

    @Bean
    public TourDAO tourDAO(){
        return new PostgresTourDAOImpl();
    }

}
