package com.gl.CustomerService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.CustomerService.bean.Customer;
import com.gl.CustomerService.bean.CustomerDTO;
import com.gl.CustomerService.dao.CustomerDao;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void save(CustomerDTO customerDTO) {
		customerDao.save(new Customer(customerDTO));
	}

	@Override
	public List<CustomerDTO> showAllCustomer() {
		List<CustomerDTO> customerList=new ArrayList<>();
		for(Customer customer:customerDao.showAllCustomer()) {
			customerList.add(new CustomerDTO(customer));
		}
		return customerList;
	}

	@Override
	public void deleteACustomer(Long customerId) {
		customerDao.deleteACustomer(customerId);

	}

	@Override
	public Long generateId() {
		return customerDao.generateId();
	}

	@Override
	public CustomerDTO showCustomer(Long customerId) {
		Customer customer=new Customer();
		customer= customerDao.showCustomer(customerId);
		CustomerDTO customerDTO=new CustomerDTO(customer);
		return customerDTO;
	}

}
