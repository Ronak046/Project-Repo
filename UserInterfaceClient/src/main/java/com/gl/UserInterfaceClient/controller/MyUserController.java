package com.gl.UserInterfaceClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.UserInterfaceClient.bean.MyUser;
import com.gl.UserInterfaceClient.service.MyUserService;

@RequestMapping("/users")
@RestController
public class MyUserController {
	@Autowired
	private MyUserService service;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@GetMapping(value="/index")
	public ModelAndView showIndexPage() {
		String pageName="";
		if(service.getUserType().equalsIgnoreCase("super"))
			pageName="superHomePage";
		else if(service.getUserType().equalsIgnoreCase("salesperson"))
			pageName="salesPersonHomePage";
		else if(service.getUserType().equalsIgnoreCase("customer"))
			pageName="customerHomePage";
		return new ModelAndView(pageName);
	}
	
	@GetMapping(value="/loginpage")
	 public ModelAndView showLoginPage() {
		 return new ModelAndView("loginPage");
	 }
	
	@GetMapping(value="/loginerror")
	 public ModelAndView showErrorPage()
	{
		 return new ModelAndView("loginErrorPage");
	 }
	
	@GetMapping(value="/super-register")
	public ModelAndView showSuperRegisterPage(Model model) {
	     MyUser users=new MyUser();
	     ModelAndView mv=new  ModelAndView("superRegisterPage");
	     mv.addObject("userRecord",users);
		return mv;
	}
	
	@PostMapping(value="/super-register")
	public ModelAndView saveSuperUser(@ModelAttribute("userRecord")  MyUser users) {
		 String encodedPassword =bCrypt.encode(users.getPassword()); // encryptes the password
		 MyUser newUser=new MyUser(); 
		 newUser.setUsername(users.getUsername());
		 newUser.setPassword(encodedPassword);
		 newUser.setEmailId(users.getEmailId());
		 newUser.setUserType("super"); 
		 service.save(newUser);
		return new ModelAndView("loginPage");
	}	
	
	@GetMapping(value="/salesPerson-register")
	public ModelAndView showSalesPersonRegisterPage(Model model) {
	     MyUser users=new MyUser();
	     ModelAndView mv=new  ModelAndView("salesPersonRegisterPage");
	     mv.addObject("userRecord",users);
		return mv;
	}
	
	@PostMapping(value="/salesPerson-register")
	public ModelAndView saveSalesPerson(@ModelAttribute("userRecord")  MyUser users) {
		 String encodedPassword =bCrypt.encode(users.getPassword()); // encryptes the password
		 MyUser newUser=new MyUser(); 
		 newUser.setUsername(users.getUsername());
		 newUser.setPassword(encodedPassword);
		 newUser.setEmailId(users.getEmailId());
		 newUser.setUserType("salesperson"); 
		 service.save(newUser);
		return new ModelAndView("loginPage");
	}
	
	@GetMapping(value="/customer-register")
	public ModelAndView showCustomerRegisterPage(Model model) {
	     MyUser users=new MyUser();
	     ModelAndView mv=new  ModelAndView("customerRegisterPage");
	     mv.addObject("userRecord",users);
		return mv;
	}
	
	@PostMapping(value="/customer-register")
	public ModelAndView saveCustomer(@ModelAttribute("userRecord")  MyUser users) {
		 String encodedPassword =bCrypt.encode(users.getPassword()); // encryptes the password
		 MyUser newUser=new MyUser(); 
		 newUser.setUsername(users.getUsername());
		 newUser.setPassword(encodedPassword);
		 newUser.setEmailId(users.getEmailId());
		 newUser.setUserType("customer"); 
		 service.save(newUser);
//		return new ModelAndView("loginPage");
		 return new ModelAndView("redirect:/logout");
	}
	
}
