package com.gl.CustomerService.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.CustomerService.bean.Customer;


@Service
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private CustomerRepository repository;
	
	@Override
	public void save(Customer customer) {
		repository.save(customer);
	}

	@Override
	public List<Customer> showAllCustomer() {
		return repository.findAll();
	}

	@Override
	public void deleteACustomer(Long customerId) {
		repository.deleteById(customerId);
	}

	@Override
	public Long generateId() {
		Long val=repository.findMaxCustomerId();	
		if (val==null) {
			val=101L;
		}
		else
			val=val+1;
		return val;
	}

	@Override
	public Customer showCustomer(Long customerId) {
		return repository.getById(customerId);
	}
}
