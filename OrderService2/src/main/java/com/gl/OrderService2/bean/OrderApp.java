package com.gl.OrderService2.bean;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class OrderApp {
@Id
private Long orderId;	
private Long clientId;
@OneToMany(fetch=FetchType.LAZY, targetEntity=Item.class,cascade=CascadeType.ALL)  
@JoinColumn(name = "orderId", referencedColumnName="orderId")
private List<Item> itemList;
public OrderApp() {
	super();
}

public OrderApp(Long orderId, Long clientId, List<Item> itemList) {
	super();
	this.orderId = orderId;
	this.clientId = clientId;
	this.itemList = itemList;
}

public OrderApp(OrderAppDTO orderAppDTO) {
	super();
	this.orderId = orderAppDTO.getOrderId();
	this.clientId = orderAppDTO.getClientId();
	this.itemList = orderAppDTO.getItemList();
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
	return "OrderApp [orderId=" + orderId + ", clientId=" + clientId + ", itemList=" + itemList
			+ "]";
}


}
