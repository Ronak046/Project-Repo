package com.gl.OrderService2.dao;
import java.util.List;

import com.gl.OrderService2.bean.OrderApp;

public interface OrderDao {
	public void saveOrder(OrderApp order);
	public List<OrderApp> showAllOrder();
	public void deleteAOrder(Long orderID);
	public Long generateOrderNo();
	public void deleteAItem(Long itemNo);
	public OrderApp showAOrder(Long orderId);
	public Double calculateCommision(String restaurantId);
	public Long generateItemNo();
	public Double calculateTotal(OrderApp order);
	public Double calculateDiscountedAmount(Double total);
	public Double FinalAmount(Double discountedAmount);
}
