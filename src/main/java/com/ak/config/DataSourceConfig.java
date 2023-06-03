package com.ak.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	@Bean(name = "h2DataSource")
    public DataSource h2DataSource()
    {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem/testdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
        
        return dataSource;
    }

    @Bean(name = "mysqlDataSource")
    @Primary
    public DataSource mysqlDataSource()
    {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
    	dataSource.setUsername("root");
    	dataSource.setPassword("");
        return dataSource;
    }
}

