package com.gl.CustomerService.service;

import java.util.List;
import com.gl.CustomerService.bean.CustomerDTO;


public interface CustomerService {
	public void save(CustomerDTO customerDTO);
	public List<CustomerDTO> showAllCustomer();
	public void deleteACustomer(Long customerId);
	public Long generateId();
	public CustomerDTO showCustomer(Long customerId);
}
