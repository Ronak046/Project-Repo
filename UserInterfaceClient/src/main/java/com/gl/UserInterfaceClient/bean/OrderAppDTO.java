package com.gl.UserInterfaceClient.bean;

import java.util.List;

public class OrderAppDTO {
private Long orderId;
private Long clientId;
private List<ItemDTO> itemList;
public OrderAppDTO() {
	super();
}

public OrderAppDTO(Long orderId, Long clientId, List<ItemDTO> itemList) {
	super();
	this.orderId = orderId;
	this.clientId = clientId;
	this.itemList = itemList;
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
public List<ItemDTO> getItemList() {
	return itemList;
}
public void setItemList(List<ItemDTO> itemList) {
	this.itemList = itemList;
}

@Override
public String toString() {
	return "OrderAppDTO [orderId=" + orderId +", clientId=" + clientId + ", itemList=" + itemList
			+ "]";
}
}
