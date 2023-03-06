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

import com.gl.UserInterfaceClient.api.RestaurantApi;
import com.gl.UserInterfaceClient.bean.RestaurantDTO;

@RequestMapping("/restaurants")
@RestController
public class RestaurantController {
	 @Autowired
	 private RestaurantApi restaurantApi;
	 
	 @GetMapping("/restaurant")
	 public ModelAndView showRestaurantIndexPage()
	 {
		 List<RestaurantDTO> restaurantList=restaurantApi.findAll();
		 ModelAndView mv=new ModelAndView("restaurantIndexPage");
		 mv.addObject("restaurantList",restaurantList);
		 return mv; 
	 }
 
	 @GetMapping("/delete-restaurant/{restaurantId}")
		public ModelAndView deleteRestaurant(@PathVariable String restaurantId)  {
			restaurantApi.deleteById(restaurantId);
			return new ModelAndView("redirect:/restaurants/restaurant");
	 }
 
	 @GetMapping("/display-restaurant/{restaurantId}")
	    public ModelAndView DisplayrestaurantById(@PathVariable String restaurantId)  {
		RestaurantDTO restaurant=restaurantApi.showARestaurant(restaurantId);
		ModelAndView mv=new ModelAndView("restaurantDisplayPage"); 
		mv.addObject("restaurant",restaurant);
		return mv;
	}
	
		@GetMapping("/restaurant-entry")
		public ModelAndView showrestaurantEntryPage()
		{
			RestaurantDTO restaurant =new RestaurantDTO();
			ModelAndView mv= new ModelAndView("restaurantEntryPage");
			mv.addObject("restaurantRecord",restaurant); 
			return mv;
		}
		
		@PostMapping("/restaurant-entry")
		public ModelAndView showMenuEntryPage(@ModelAttribute("restaurantRecord") RestaurantDTO restaurant )
		{
			restaurantApi.save(restaurant);
			return new ModelAndView("redirect:/restaurants/restaurant");
		}
		
		 @GetMapping("/show-menu")
		 public ModelAndView showMenuPage()
		 {
			 List<RestaurantDTO> restaurantList=restaurantApi.findAll();
			 ModelAndView mv=new ModelAndView("menuPage");
			 mv.addObject("restaurantList",restaurantList);
			 return mv; 
		 }
		 
}
