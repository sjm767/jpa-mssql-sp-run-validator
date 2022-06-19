package com.sample.jpa.code.gen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "testWriteEntityManagerFactory"
        , transactionManagerRef = "testWriteTransactionManager"
        , basePackages = "com.sample.jpa.code.gen.repository"
)
public class TestWriteConfig {
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean
    @Primary
    public PlatformTransactionManager testWriteTransactionManager(@Qualifier(value = "testWriteEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean testWriteEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                                  DataSource ds) {

        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());

        return builder
                .dataSource(ds)
                .packages("com.sample.jpa.code.gen.entity")
                .persistenceUnit("testWriteEntityManager")
                .properties(properties)
                .build();
    }
}
