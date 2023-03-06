package com.gl.CustomerService.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gl.CustomerService.bean.CustomerDTO;
import com.gl.CustomerService.service.CustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/customer",produces =MediaType.APPLICATION_JSON_VALUE )
	public List<CustomerDTO> findAll(){
		return customerService.showAllCustomer();
	}
	
	@DeleteMapping(value = "/customer/{customerId}",produces =MediaType.APPLICATION_JSON_VALUE )
	public String deleteById(@PathVariable Long customerId){
		customerService.deleteACustomer(customerId);
		return "Customer Deleted";
	}
	
	@GetMapping(value = "/customer/{customerId}",produces =MediaType.APPLICATION_JSON_VALUE )
	public CustomerDTO  showAcustomer(@PathVariable Long customerId){
		return customerService.showCustomer(customerId); 
	}
	
	@PostMapping(value = "/customer-entry",consumes =MediaType.APPLICATION_JSON_VALUE )
	public String save(@RequestBody CustomerDTO customerDTO){
		Long val=customerService.generateId();
		customerDTO.setCustomerId(val);
		customerDTO.setStatus("Cleared");
		customerService.save(customerDTO);
		return "New customer saved";
	}
	
	@PutMapping(value="/edit-customer",consumes =MediaType.APPLICATION_JSON_VALUE)
	public String editCustomer(@RequestBody CustomerDTO customerDTO)  {
		CustomerDTO c=customerService.showCustomer(customerDTO.getCustomerId());
		c.setStatus(customerDTO.getStatus());
		customerService.save(c);
		return "Status Updated";
	}

}
