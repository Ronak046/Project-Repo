package com.gl.RestaurantService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.RestaurantService.bean.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
	@Query("select max(restaurantId) from Restaurant")
	public String findMaxRestaurantId(); 
}
