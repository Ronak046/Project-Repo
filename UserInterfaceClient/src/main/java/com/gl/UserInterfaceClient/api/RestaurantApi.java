package com.gl.UserInterfaceClient.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.gl.UserInterfaceClient.bean.MenuDTO;
import com.gl.UserInterfaceClient.bean.RestaurantDTO;

@FeignClient(name="RESTAURANT-SERVICE")
public interface RestaurantApi {
	@GetMapping("/restaurants/restaurant")
	public List<RestaurantDTO> findAll();
	@PostMapping("/restaurants/restaurant-entry")
	public String save(@RequestBody RestaurantDTO restaurantDTO);
	@DeleteMapping("/restaurants/restaurant/{restaurantId}")
	public String deleteById(@PathVariable String restaurantId);
	@GetMapping("/restaurants/restaurant/{restaurantId}")
	public RestaurantDTO  showARestaurant(@PathVariable String restaurantId);
	@GetMapping("/menu")
	public List<MenuDTO> findMenu();

}
