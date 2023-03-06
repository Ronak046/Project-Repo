package com.gl.UserInterfaceClient.controller;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.gl.UserInterfaceClient.api.OrderApi;
import com.gl.UserInterfaceClient.bean.ItemDTO;
import com.gl.UserInterfaceClient.bean.OrderAppDTO;
import com.gl.UserInterfaceClient.exception.AmountException;

@RequestMapping("/orders")
@RestController
public class OrderController {
	@Autowired
	private OrderApi orderApi;
	
	@GetMapping("/order-show")
	public ModelAndView showOrderIndexPage() {
		ModelAndView mv=new ModelAndView("orderIndexPage");
		List<OrderAppDTO> orderList=orderApi.findAll();
		mv.addObject("orderList",orderList);
		return mv;
	}
	
	@GetMapping("/delete-item/{itemNo}")
	public ModelAndView deleteAItem(@PathVariable Long itemNo) {
		orderApi.deleteItemById(itemNo);
		ModelAndView mv=new ModelAndView("redirect:/orders/order-show"); 
		return mv;
	}
}
