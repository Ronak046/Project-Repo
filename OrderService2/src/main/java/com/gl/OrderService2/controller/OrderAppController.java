package com.gl.OrderService2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gl.OrderService2.bean.OrderAppDTO;
import com.gl.OrderService2.service.OrderService;

@RequestMapping("/orders")
@RestController
public class OrderAppController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/order",produces =MediaType.APPLICATION_JSON_VALUE )
	public List<OrderAppDTO> findAll(){
		return orderService.showAllOrder();
	}
	
	@GetMapping(value = "/order/{orderId}",produces =MediaType.APPLICATION_JSON_VALUE )
	public OrderAppDTO  showAOrder(@PathVariable Long orderId){
		return orderService.showAOrder(orderId);
	}
	
	@DeleteMapping(value = "/order-delete/{orderId}",produces =MediaType.APPLICATION_JSON_VALUE )
	public String deleteOrderById(@PathVariable Long orderId){
		orderService.deleteAOrder(orderId);
		return "Order Deleted";
	}
	
	@DeleteMapping(value = "/item-delete/{itemNo}",produces =MediaType.APPLICATION_JSON_VALUE )
	public String deleteItemById(@PathVariable Long itemNo){
		orderService.deleteAItem(itemNo);
		return "Item Deleted";
	}
	
	@GetMapping(value = "/order-commission/{restaurantId}",produces =MediaType.APPLICATION_JSON_VALUE )
	public Double generateCommission(@PathVariable String restaurantId){
		return orderService.calculateCommision(restaurantId);
	}
	
	@PostMapping(value = "/order-entry",consumes =MediaType.APPLICATION_JSON_VALUE )
	public String saveAOrder(@RequestBody OrderAppDTO orderAppDTO){
//		Long str=orderService.generateOrderNo();
//		orderAppDTO.setOrderId(str);
//		for(Item i:orderAppDTO.getItemList())
//		{
//			i.setItemNo(orderService.generateItemNo());
//		}
		orderService.saveOrder(orderAppDTO);
		return "order saved";
	}
	
	@PostMapping(value = "/order-entry1",consumes =MediaType.APPLICATION_JSON_VALUE )
	public String saveAnOrder(@RequestBody OrderAppDTO orderAppDTO){
		Long str=orderService.generateOrderNo();
		orderAppDTO.setOrderId(str);
		orderService.saveOrder(orderAppDTO);
		return "order saved";
	}
	
	@GetMapping(value="/order-total",produces =MediaType.APPLICATION_JSON_VALUE)
	public Double calculateTotal(@RequestBody OrderAppDTO orderAppDTO) {
		Double totalAmt=orderService.calculateTotal(orderAppDTO);
		return totalAmt;
	}
	
	@GetMapping(value="/order-discountedAmount/{total}",produces =MediaType.APPLICATION_JSON_VALUE)
	public Double calculatediscountedAmount(@PathVariable Double total) {
		return orderService.calculateDiscountedAmount(total);
	}
	
	@GetMapping(value="/order-taxAmount/{discountedAmount}",produces =MediaType.APPLICATION_JSON_VALUE)
	public Double calculatetaxAmount(@PathVariable Double discountedAmount) {
		return orderService.FinalAmount(discountedAmount);
	}
	
	@GetMapping(value="/order-generateId/",produces =MediaType.APPLICATION_JSON_VALUE)
	public Long generateId() {
		return orderService.generateOrderNo();
	}
	
	@GetMapping(value="/item-generateId/",produces =MediaType.APPLICATION_JSON_VALUE)
	public Long generateItemId() {
		return orderService.generateItemNo();
	}
	
}
