package com.gl.OrderService2.service;

import java.util.List;
import com.gl.OrderService2.bean.OrderAppDTO;


public interface OrderService {
	public void saveOrder(OrderAppDTO orderAppDTO);
	public List<OrderAppDTO> showAllOrder();
	public void deleteAOrder(Long orderID);
	public Long generateOrderNo();
	public void deleteAItem(Long itemNo);
	public OrderAppDTO showAOrder(Long orderId);
	public Double calculateCommision(String restaurantId);
	public Long generateItemNo();
	public Double calculateTotal(OrderAppDTO order);
	public Double calculateDiscountedAmount(Double total);
	public Double FinalAmount(Double discountedAmount);
}
