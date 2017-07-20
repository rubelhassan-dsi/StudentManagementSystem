package com.rubel.sms.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by rubel on 7/16/17.
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database/db_config.properties")
@ComponentScan(basePackages = {"com.rubel.sms"})
public class DbConfig {

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.url}")
    private String host;

    @Value("${db.driverClass}")
    private String driverName;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverName);
        basicDataSource.setUrl(host);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        return  basicDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.rubel.sms");
        sessionFactoryBean.setHibernateProperties(getHibernateProperties());
        return sessionFactoryBean;
    }


    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

    private Properties getHibernateProperties(){
        Properties pc = new Properties();
        pc.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        pc.setProperty("hibernate.hbm2ddl.auto", "none");
        pc.setProperty("hibernate.format_sql", "true");
        pc.setProperty("hibernate.show_sql", "true");
        pc.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        pc.setProperty("use_sql_comments", "true");
        return pc;
    }
}
