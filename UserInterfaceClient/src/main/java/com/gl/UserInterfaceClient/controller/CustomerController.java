package com.gl.UserInterfaceClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.UserInterfaceClient.api.CustomerApi;
import com.gl.UserInterfaceClient.bean.CustomerDTO;

@RequestMapping("/customers")
@RestController
public class CustomerController {
	@Autowired
	private CustomerApi customerApi;
	
	@GetMapping("/customer")
	public ModelAndView showIndexPage()	
	{
		ModelAndView mv=new ModelAndView("customerIndexPage"); 
		List<CustomerDTO> customerList=customerApi.findAll();
		mv.addObject("customerList",customerList);
		return mv;
	}
	
	@GetMapping("/delete-customer/{customerId}")
	public ModelAndView DeleteCustomer(@PathVariable Long customerId)  {
		customerApi.deleteById(customerId);
		return new ModelAndView("redirect:/customers/customer");
	}
	
	@GetMapping("/show-customer/{customerId}")
	public ModelAndView showACustomer(@PathVariable Long customerId)  {
		CustomerDTO customerDTO=customerApi.showAcustomer(customerId);
		ModelAndView mv= new ModelAndView("customerShowPage");
		mv.addObject("customer",customerDTO);
		return mv;
	}
	
	@GetMapping("/customer-entry")
	public ModelAndView showCustomerEntryPage()
	{
		CustomerDTO customer =new CustomerDTO();
		ModelAndView mv= new ModelAndView("customerEntryPage");
		mv.addObject("customerRecord",customer); 
		return mv;
	}
	
	@PostMapping("/customer-entry")
	public ModelAndView showCustomerEntryPage(@ModelAttribute("customerRecord") CustomerDTO customer )
	{
		customerApi.save(customer);
		return new ModelAndView("redirect:/customers/customer");
	}
	
}
