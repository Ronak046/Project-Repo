package com.gl.OrderService2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.OrderService2.bean.Item;
import com.gl.OrderService2.bean.OrderApp;
import com.gl.OrderService2.exception.AmountException;

@Service
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ItemRepository repository1;
	
	@Override
	public void saveOrder(OrderApp order) {
		repository.save(order);
	}

	@Override
	public List<OrderApp> showAllOrder() {
		return repository.findAll();
	}

	@Override
	public Long generateOrderNo() {
		Long val=repository.findMaxOrderId();
		if (val==null) {
			val=1001L;
		}
		else
			val=val+1;
		return val;
	}

	@Override
	public void deleteAOrder(Long orderID) {
		 repository.deleteById(orderID);
		
	}

	@Override
	public void deleteAItem(Long itemNo) {
		 repository1.deleteById(itemNo);
		
	}

	@Override
	public OrderApp showAOrder(Long orderId) {
		return repository.getById(orderId);
	}

	@Override
	public Double calculateCommision(String restaurantId) {
		List<Item> itemList=repository1.findItemByRestaurantId(restaurantId);
		Double restAmt=0.0;
		Double commission=0.0;
		for(Item i:itemList)
		{
			restAmt=restAmt+i.getAmount();
		}
		if(restAmt>=5000)
			commission=(restAmt*0.05);
		else if(restAmt>=10000)
			commission=(restAmt*0.1);
		return commission;
	}

	@Override
	public Long generateItemNo() {
		Long val=repository1.findMaxItemNo();
		if (val==null) {
			val=1L;
		}
		return val;
	}

	@Override
	public Double calculateTotal(OrderApp order) {
		Double total=0.0;
		 order=repository.getById(order.getOrderId());
		for(Item i:order.getItemList())
		{
			total=total+i.getAmount();
		}
		return total;
	}

	@Override
	public Double calculateDiscountedAmount(Double total) {
		if(total<=500)
			throw new AmountException();
		if(total>=2500)
			total=total-((total*2.5)/100);
		else if(total>=5000)
			total=total-((total*5)/100);
		else if(total>=10000)
			total=total-((total*10)/100);
		Double discountedAmount=total;
		return discountedAmount;
	}

	@Override
	public Double FinalAmount(Double discountedAmount) {
		Double taxAmt=discountedAmount+(0.125*discountedAmount);
		taxAmt=taxAmt+(0.1*taxAmt);
		return taxAmt;
	}

}
