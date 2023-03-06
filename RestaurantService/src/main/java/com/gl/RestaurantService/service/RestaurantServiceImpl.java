package com.gl.RestaurantService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.RestaurantService.bean.Menu;
import com.gl.RestaurantService.bean.MenuDTO;
import com.gl.RestaurantService.bean.Restaurant;
import com.gl.RestaurantService.bean.RestaurantDTO;
import com.gl.RestaurantService.dao.RestaurantDao;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	public void RestaurantDTOSave(RestaurantDTO restaurantDTO) {
			Restaurant restaurant=new Restaurant(restaurantDTO);
			restaurantDao.RestaurantSave(restaurant);
	}

	@Override
	public List<RestaurantDTO> showAllRestaurantDTO() {
		List<RestaurantDTO> restaurantList=new ArrayList<>();
		for(Restaurant restaurant:restaurantDao.showAllRestaurant()) {
			RestaurantDTO RestaurantDTO=new RestaurantDTO(restaurant);
			restaurantList.add(RestaurantDTO);
		}
		return restaurantList;
	}

	@Override
	public String generateId() {
		return restaurantDao.generateId();
	}

	@Override
	public void deleteARestaurant(String restaurantId) {
		restaurantDao.deleteARestaurant(restaurantId);
		
	}

	@Override
	public RestaurantDTO showARestaurant(String restaurantId) {
		Restaurant restaurant=new Restaurant();
		restaurant=restaurantDao.showARestaurant(restaurantId);
		RestaurantDTO restaurantDTO=new RestaurantDTO(restaurant);
		return restaurantDTO;
	}

	@Override
	public List<MenuDTO> showMenu() {
		List<MenuDTO> menuList=new ArrayList<>();
		for(Menu menu:restaurantDao.showMenu()) {
			MenuDTO menuDTO=new MenuDTO(menu);
			menuList.add(menuDTO);
		}
		return menuList;
	}

}
