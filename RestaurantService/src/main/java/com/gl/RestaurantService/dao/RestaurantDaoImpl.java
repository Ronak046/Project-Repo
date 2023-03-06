package com.gl.RestaurantService.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.RestaurantService.bean.Menu;
import com.gl.RestaurantService.bean.Restaurant;


@Service
public class RestaurantDaoImpl implements RestaurantDao {

	@Autowired
	private RestaurantRepository repository;
	
	@Autowired
	private MenuRepository repository2;
	
	
	@Override
	public void RestaurantSave(Restaurant restaurant) {
		repository.save(restaurant);

	}

	@Override
	public List<Restaurant> showAllRestaurant() {
		return repository.findAll();
	}
	
	@Override
	public void deleteARestaurant(String restaurantId) {
		repository.deleteById(restaurantId);
	}

	@Override
	public String generateId() {
		String val=repository.findMaxRestaurantId();
		Long l;
		String temp;
		if(val==null) {
			 l=1001L;
			temp=String.valueOf(l);
		}
			
		else {
			String var=val.substring(1);
			Long k=Long.parseLong(var);
			k=k+1;
			temp=String.valueOf(k);
		}
		return "R"+temp;
	}

	@Override
	public Restaurant showARestaurant(String restaurantId) {
		return repository.getById(restaurantId);
	}

	@Override
	public List<Menu> showMenu() {
		return repository2.findAll();
	}

}
