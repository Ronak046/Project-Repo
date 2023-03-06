package com.gl.UserInterfaceClient.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gl.UserInterfaceClient.bean.CustomerDTO;


@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerApi {	
	@GetMapping("/customers/customer")
	public List<CustomerDTO> findAll();
	@GetMapping("/customers/customer/{customerId}")
	public CustomerDTO  showAcustomer(@PathVariable Long customerId);
	@PostMapping("/customers/customer-entry")
	public String save(@RequestBody CustomerDTO customerDTO);
	@PutMapping("/customers/edit-customer")
	public String editCustomer(@RequestBody CustomerDTO customerDTO);
	@DeleteMapping("/customers/customer/{customerId}")
	public String deleteById(@PathVariable Long customerId);
	
}
