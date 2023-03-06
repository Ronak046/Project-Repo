package com.gl.RestaurantService.bean;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Restaurant {
	@Id
	private String restaurantId;
	private String restaurantName;
	private String foodType;
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Menu.class,cascade=CascadeType.ALL)  
	@JoinColumn(name = "restaurantId", referencedColumnName="restaurantId")
	private List<Menu> menuList;
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(String restaurantId, String restaurantName, String foodType, List<Menu> menuList) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.foodType = foodType;
		this.menuList = menuList;
	}
	
	public Restaurant(RestaurantDTO restaurantDTO) {
		super();
		this.restaurantId = restaurantDTO.getRestaurantId();
		this.restaurantName = restaurantDTO.getRestaurantName();
		this.foodType = restaurantDTO.getFoodType();
		this.menuList = restaurantDTO.getMenuList();
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
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", foodType="
				+ foodType + ", menuList=" + menuList + "]";
	}
	
	
}
