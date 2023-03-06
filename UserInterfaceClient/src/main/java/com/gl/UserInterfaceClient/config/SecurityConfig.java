package com.gl.UserInterfaceClient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gl.UserInterfaceClient.service.MyUserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
	private MyUserService service;
	@Autowired
	private EncoderConfig econfig;
		
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder authority) throws Exception {
		authority.userDetailsService(service).passwordEncoder(econfig.passwordEncoder());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/users/customer-register").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/users/loginpage").defaultSuccessUrl("/users/index")
		.failureUrl("/users/loginerror").loginProcessingUrl("/users/login")
		.permitAll().and().logout()
		.logoutSuccessUrl("/users/index");
		 http.csrf().disable();
	}	
}
