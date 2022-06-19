package com.sample.jpa.code.gen.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean(name="testWriteDataSource")
    public DataSource testWriteDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceBuilder.url("jdbc:sqlserver://localhost:3950;DatabaseName=testdb");
        dataSourceBuilder.username("user");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }
}
