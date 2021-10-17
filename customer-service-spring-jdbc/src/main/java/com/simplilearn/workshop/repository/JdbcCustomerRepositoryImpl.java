package com.simplilearn.workshop.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Customer;

@Repository(value = "customerRepository")
// Note, the default bean name is the class name with lower-case first letter (inMemoryCustomerRepositoryImpl), but by setting the value above, we customize it
public class JdbcCustomerRepositoryImpl implements CustomerRepository {

	private static final String SQL_CUSTOMERS_COUNT = "SELECT count(*) FROM customers";
	private static final String SQL_CUSTOMERS_SELECT = "SELECT * FROM customers";
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcCustomerRepositoryImpl(DataSource dataSource){
		System.out.println("Spring has assembled a datasource bean.");
		// Create a JDBC template
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Customer> findAll() {
		//return jdbcTemplate.query(SQL_CUSTOMERS_SELECT, new CustomerRowMapper());
		return jdbcTemplate.query(SQL_CUSTOMERS_SELECT,(rs,rowNum)-> new Customer(rs.getLong("ID"),rs.getString("NAME"), rs.getString("EMAIL"), rs.getString("PHONE")));
	}
		
	@Override
	public Integer findNoOfCustomers() {
		return jdbcTemplate.queryForObject(SQL_CUSTOMERS_COUNT, Integer.class);
	}

}

//class CustomerRowMapper implements RowMapper<Customer> {
//
//	@Override
//	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Customer customer = new Customer();
//		customer.setId(rs.getLong("id"));
//		customer.setName(rs.getString("name"));
//		customer.setPhone(rs.getString("phone"));
//		customer.setEmail(rs.getString("email"));
//		return customer;
//	}
	
//}
