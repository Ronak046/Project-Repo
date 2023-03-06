package com.gl.OrderService2.bean;

import java.util.List;

public class OrderAppDTO {
private Long orderId;
private Long clientId;
private List<Item> itemList;
public OrderAppDTO() {
	super();
}

public OrderAppDTO(Long orderId, Long clientId, List<Item> itemList) {
	super();
	this.orderId = orderId;
	this.clientId = clientId;
	this.itemList = itemList;
}
public OrderAppDTO(OrderApp orderApp) {
	super();
	this.orderId = orderApp.getOrderId();
	this.clientId = orderApp.getClientId();
	this.itemList = orderApp.getItemList();
}

public Long getOrderId() {
	return orderId;
}
public void setOrderId(Long orderId) {
	this.orderId = orderId;
}
public Long getClientId() {
	return clientId;
}
public void setClientId(Long clientId) {
	this.clientId = clientId;
}
public List<Item> getItemList() {
	return itemList;
}
public void setItemList(List<Item> itemList) {
	this.itemList = itemList;
}

@Override
public String toString() {
	return "OrderAppDTO [orderId=" + orderId +", clientId=" + clientId + ", itemList=" + itemList
			+ "]";
}
}
