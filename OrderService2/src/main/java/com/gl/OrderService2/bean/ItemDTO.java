package com.gl.OrderService2.bean;
import java.time.LocalDate;

public class ItemDTO {
	private Long itemNo;
	private String	itemName;
	private String restaurantId;		
	private Integer	quantity;	
	private Double	amount;
	private LocalDate orderDate=LocalDate.now();
	private	String orderStatus="Waiting";	
	private String	payStatus="Pending";
	private Long orderId;
	public ItemDTO() {
		super();
	}
	
	public ItemDTO(Long orderId) {
		super();
		this.orderId = orderId;
	}
	
	public ItemDTO(Long itemNo, String itemName, String restaurantId, Integer quantity, Double amount, LocalDate orderDate,
			String orderStatus, String payStatus, Long orderId) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.restaurantId = restaurantId;
		this.quantity = quantity;
		this.amount = amount;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.payStatus = payStatus;
		this.orderId = orderId;
	}
	
	public ItemDTO(Item item) {
		super();
		this.itemNo = item.getItemNo();
		this.itemName = item.getItemName();
		this.restaurantId = item.getRestaurantId();
		this.quantity = item.getQuantity();
		this.amount = item.getAmount();
		this.orderDate = item.getOrderDate();
		this.orderStatus = item.getOrderStatus();
		this.payStatus = item.getPayStatus();
		this.orderId = item.getOrderId();
	}

	public Long getItemNo() {
		return itemNo;
	}
	public void setItemNo(Long itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", restaurantId=" + restaurantId + ", quantity="
				+ quantity + ", amount=" + amount + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", payStatus=" + payStatus + ", orderId=" + orderId + "]";
	}
}
