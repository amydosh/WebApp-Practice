package com.simplilearn.workshop.config;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.simplilearn.workshop.repository.CustomerRepository;
import com.simplilearn.workshop.repository.JdbcCustomerRepositoryImpl;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.CustomerServiceImpl;

@Configuration

// Below is an example of BAD practice...because it will look through all of your packages, you want to specify the ones you need to reduce startup time
//@ComponentScan(basePackages="com.simplilearn.workshop")
@ComponentScan(basePackages = "com.simplilearn.workshop.respository, com.simplilearn.workshop.services")
@Import(value=InfraStructureConfig.class)
public class CustomerServiceConfig {
	
	

		
	}

