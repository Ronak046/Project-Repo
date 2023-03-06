package com.gl.RestaurantService.service;

import java.util.List;
import com.gl.RestaurantService.bean.MenuDTO;
import com.gl.RestaurantService.bean.RestaurantDTO;

public interface RestaurantService {
	public void RestaurantDTOSave(RestaurantDTO RestaurantDTO);
	public List<RestaurantDTO> showAllRestaurantDTO();
	public void deleteARestaurant(String restaurantId);
	public String generateId();
	public RestaurantDTO showARestaurant(String restaurantId);
	public List<MenuDTO> showMenu();
}
