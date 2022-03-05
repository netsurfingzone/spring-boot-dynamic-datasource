package com.netsurfingzone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory",
        transactionManagerRef = "oracleTransactionManager", basePackages = "com.netsurfingzone.repository.oracle")
public class OracleDatasourceConfig {

    @Bean("oracleDatasource")
    public DataSource dataSource() {
        DataSource dataSource = null;

        Context ctx = null;
        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "oracleEntityManager")
    public EntityManager entityManager() {
        EntityManager entityManager = null;
        entityManager = entityManagerFactory().createEntityManager();
        return entityManager;
    }


    @Bean(name = "oracleEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setJpaVendorAdapter(vendorAdaptor());
        emf.setPackagesToScan("com.netsurfingzone");
        emf.setPersistenceUnitName("oracle");
        emf.afterPropertiesSet();

        return emf.getObject();
    }

    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory());
        return tm;
    }

    private HibernateJpaVendorAdapter vendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

}
