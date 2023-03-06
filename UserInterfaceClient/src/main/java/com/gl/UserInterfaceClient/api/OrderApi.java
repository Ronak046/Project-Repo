package com.gl.UserInterfaceClient.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gl.UserInterfaceClient.bean.OrderAppDTO;


@FeignClient(name="ORDER-SERVICE")
public interface OrderApi {
	@GetMapping("/orders/order")
	public List<OrderAppDTO> findAll();
	@GetMapping("/orders/order/{orderId}")
	public OrderAppDTO  showAOrder(@PathVariable Long orderId);
	@DeleteMapping("/orders/item-delete/{itemNo}" )
	public String deleteItemById(@PathVariable Long itemNo);
	@GetMapping("/orders/order-commission/{restaurantId}" )
	public Double generateCommission(@PathVariable String restaurantId);
	@PostMapping("/orders/order-entry")
	public String saveAOrder(@RequestBody OrderAppDTO orderAppDTO);
	@PostMapping("/orders/order-entry1" )
	public String saveAnOrder(@RequestBody OrderAppDTO orderAppDTO);
	@GetMapping("/orders/order-generateId/")
	public Long generateId();
	@GetMapping("/orders/item-generateId/")
	public Double calculatetaxAmount(@PathVariable Double discountedAmount);
	@GetMapping("/orders/order-discountedAmount/{total}")
	public Double calculatediscountedAmount(@PathVariable Double total);
	@GetMapping("/orders/order-total")
	public Double calculateTotal(@RequestBody OrderAppDTO orderAppDTO);
	@GetMapping("/orders/item-generateId/")
	public Long generateItemId();
}
