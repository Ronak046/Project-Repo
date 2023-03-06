package com.gl.RestaurantService.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	@Id
	private Long slno;
	private String itemName;
	private Double price;
	private String restaurantId;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Menu(Long slno, String itemName, Double price, String restaurantId) {
		super();
		this.slno = slno;
		this.itemName = itemName;
		this.price = price;
		this.restaurantId = restaurantId;
	}
	
	public Menu(MenuDTO menuDTO) {
		super();
		this.slno = menuDTO.getSlno();
		this.itemName = menuDTO.getItemName();
		this.price = menuDTO.getPrice();
		this.restaurantId = menuDTO.getRestaurantId();
	}
	
	public Menu(String restaurantId) {
		super();
		this.restaurantId = restaurantId;
	}

	public Long getSlno() {
		return slno;
	}

	public void setSlno(Long slno) {
		this.slno = slno;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "Menu [slno=" + slno + ", itemName=" + itemName + ", price=" + price + ", restaurantId=" + restaurantId
				+ "]";
	}
	
}
