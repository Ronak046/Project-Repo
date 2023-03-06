package com.gl.RestaurantService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gl.RestaurantService.bean.MenuDTO;
import com.gl.RestaurantService.bean.RestaurantDTO;
import com.gl.RestaurantService.service.RestaurantService;


@RequestMapping("/restaurants")
@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	
	@GetMapping(value = "/restaurant",produces =MediaType.APPLICATION_JSON_VALUE )
	public List<RestaurantDTO> findAll(){
		return restaurantService.showAllRestaurantDTO();
	}
	
	@GetMapping(value = "/menu",produces =MediaType.APPLICATION_JSON_VALUE )
	public List<MenuDTO> findMenu(){
		return restaurantService.showMenu();
	}
	
	@GetMapping(value = "/restaurant/{restaurantId}",produces =MediaType.APPLICATION_JSON_VALUE )
	public RestaurantDTO  showARestaurant(@PathVariable String restaurantId){
		return restaurantService.showARestaurant(restaurantId);
	}
	
	@DeleteMapping(value = "/restaurant/{restaurantId}",produces =MediaType.APPLICATION_JSON_VALUE )
	public String deleteById(@PathVariable String restaurantId){
		restaurantService.deleteARestaurant(restaurantId);
		return "Restaurant Deleted";
	}
	
//	@PostMapping(value = "/restaurant",consumes =MediaType.APPLICATION_JSON_VALUE )
//	public String saveMenu(@ModelAttribute Menu menu,@RequestBody RestaurantDTO restaurantDTO)
//	{
//		menuList.add(menu);
//		restaurantDTO.setMenuList(menuList);
//		restaurantService.RestaurantDTOSave(restaurantDTO);
//		return "Menu saved";
//	}
	
//	@PostMapping(value = "/restaurant",consumes =MediaType.APPLICATION_JSON_VALUE )
//	public String saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
//		String str=restaurantService.generateId();
//		restaurantDTO.setRestaurantId(str);
//		restaurantService.RestaurantDTOSave(restaurantDTO);
//		return "Restaurant saved";
//	}
	
	@PostMapping(value = "/restaurant-entry",consumes =MediaType.APPLICATION_JSON_VALUE )
	public String save(@RequestBody RestaurantDTO restaurantDTO){
		String str=restaurantService.generateId();
		restaurantDTO.setRestaurantId(str);
		restaurantService.RestaurantDTOSave(restaurantDTO);
		return "New Restaurant saved";
	}
	
}
