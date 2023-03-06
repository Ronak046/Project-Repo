package com.gl.CustomerService.dao;

import java.util.List;

import com.gl.CustomerService.bean.Customer;


public interface CustomerDao {
	public void save(Customer customer);
	public List<Customer> showAllCustomer();
	public void deleteACustomer(Long customerId);
	public Long generateId();
	public Customer showCustomer(Long customerId);
}
