package com.gl.UserInterfaceClient.bean;

import java.util.List;


public class RestaurantDTO {
	private String restaurantId;
	private String restaurantName;
	private String foodType;
	private List<MenuDTO> menuList;
	public RestaurantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantDTO(String restaurantId, String restaurantName, String foodType, List<MenuDTO> menuList) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.foodType = foodType;
		this.menuList = menuList;
	}
	
	public RestaurantDTO(String restaurantName, String foodType) {
		super();
		this.restaurantName = restaurantName;
		this.foodType = foodType;
	}
	
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public List<MenuDTO> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuDTO> menuList) {
		this.menuList = menuList;
	}
	@Override
	public String toString() {
		return "RestaurantDTO [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", foodType="
				+ foodType + ", menuList=" + menuList + "]";
	}
	
}

