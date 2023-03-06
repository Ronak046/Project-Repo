package com.gl.UserInterfaceClient.bean;


public class MenuDTO {
	private Long slno;
	private String itemName;
	private Double price;
	private String restaurantId;
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MenuDTO(Long slno, String itemName, Double price, String restaurantId) {
		super();
		this.slno = slno;
		this.itemName = itemName;
		this.price = price;
		this.restaurantId = restaurantId;
	}
	
	public MenuDTO(String restaurantId) {
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
