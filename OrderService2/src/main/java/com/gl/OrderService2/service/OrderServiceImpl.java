package com.gl.OrderService2.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gl.OrderService2.bean.OrderApp;
import com.gl.OrderService2.bean.OrderAppDTO;
import com.gl.OrderService2.dao.OrderDao;

@Service
@Repository
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void saveOrder(OrderAppDTO orderAppDTO) {
		OrderApp orderApp=new OrderApp(orderAppDTO);
		orderDao.saveOrder(orderApp);
	}

	@Override
	public List<OrderAppDTO> showAllOrder() {
		List<OrderAppDTO> orderList = new ArrayList<>();
		for(OrderApp orderApp: orderDao.showAllOrder()) {
			OrderAppDTO orderAppDTO = new OrderAppDTO(orderApp);
			orderList.add(orderAppDTO);
		}
		return orderList;
	}

	@Override
	public void deleteAOrder(Long orderID) {
		orderDao.deleteAOrder(orderID);
	}

	@Override
	public Long generateOrderNo() {
		return orderDao.generateOrderNo();
	}
	
	/*@Override
	public Long generateItemNo() {
		return orderDao.generateItemNo();
	}*/
	
	@Override
	public void deleteAItem(Long itemNo) {
		orderDao.deleteAItem(itemNo);
	}

	@Override
	public OrderAppDTO showAOrder(Long orderId) {
		OrderApp orderApp=orderDao.showAOrder(orderId);
		OrderAppDTO orderAppDTO =new OrderAppDTO(orderApp);
		return orderAppDTO;
	}

	@Override
	public Double calculateCommision(String restaurantId) {
		return orderDao.calculateCommision(restaurantId);
	
	}

	@Override
	public Long generateItemNo() {
		return orderDao.generateItemNo();
	}

	@Override
	public Double calculateDiscountedAmount(Double total) {
		return orderDao.calculateDiscountedAmount(total);
	}

	@Override
	public Double FinalAmount(Double discountedAmount) {
		return orderDao.FinalAmount(discountedAmount);
	}

	@Override
	public Double calculateTotal(OrderAppDTO order) {
		OrderApp orderApp =new OrderApp(order); 
		return orderDao.calculateTotal(orderApp);
	}
}
