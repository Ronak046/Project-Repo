package com.gl.RestaurantService.dao;

import java.util.List;

import com.gl.RestaurantService.bean.Menu;
import com.gl.RestaurantService.bean.Restaurant;

public interface RestaurantDao {
	public void RestaurantSave(Restaurant restaurant);
	public List<Restaurant> showAllRestaurant();
	public void deleteARestaurant(String restaurantId);
	public String generateId();
	public Restaurant showARestaurant(String restaurantId );
	public List<Menu> showMenu();
}
