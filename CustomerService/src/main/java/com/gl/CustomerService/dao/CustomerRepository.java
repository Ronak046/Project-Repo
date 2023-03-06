package com.gl.CustomerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.CustomerService.bean.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("select max(customerId) from Customer")
	public Long findMaxCustomerId(); 
}
