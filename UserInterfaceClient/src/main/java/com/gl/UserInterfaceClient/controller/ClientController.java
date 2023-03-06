package com.gl.UserInterfaceClient.controller;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import com.gl.UserInterfaceClient.api.CustomerApi;
import com.gl.UserInterfaceClient.api.OrderApi;
import com.gl.UserInterfaceClient.api.RestaurantApi;
import com.gl.UserInterfaceClient.bean.CustomerDTO;
import com.gl.UserInterfaceClient.bean.ItemDTO;
import com.gl.UserInterfaceClient.bean.MenuDTO;
import com.gl.UserInterfaceClient.bean.OrderAppDTO;
import com.gl.UserInterfaceClient.bean.RestaurantDTO;
import com.gl.UserInterfaceClient.exception.AmountException;

@RestControllerAdvice
@RequestMapping("/client")
@RestController
public class ClientController {
@Autowired 
private OrderApi orderApi;
@Autowired 
private RestaurantApi restaurantApi;
@Autowired 
private CustomerApi customerApi;

private OrderAppDTO newOrderAppDTO=new OrderAppDTO();
private List<ItemDTO> itemList=new ArrayList<>();
private OrderAppDTO newOrderAppDTO2=new OrderAppDTO();
private OrderAppDTO resumeOrderDto=new OrderAppDTO();
private Long clientId;
private Long orderId;

@GetMapping("/order-entry")
public ModelAndView showOrderEntryPage() {
	OrderAppDTO orderDTO =new OrderAppDTO();
	ModelAndView mv= new ModelAndView("orderEntryPage");
	mv.addObject("orderRecord",orderDTO); 
	return mv;
}

@PostMapping("/order-entry")
public ModelAndView showItemEntryPage(@RequestParam("clientId") Long cId)
{
	orderId=orderApi.generateId();
	ItemDTO itemDTO=new ItemDTO();
	clientId=cId;
	ModelAndView mv= new ModelAndView("orderEntryPage2");
	mv.addObject("itemRecord",itemDTO);
	return mv;
}

@PostMapping("/item-entry")
public ModelAndView showOrderEntryPage2(@ModelAttribute("itemRecord") ItemDTO itemDTO,@RequestParam(required = false,value="Next") String Next,@RequestParam(required = false,value="Finish") String Finish) {
	Double total=0.0;
	Long itemN=orderApi.generateItemId();
	itemDTO.setOrderId(orderId);
	itemList.add(itemDTO);
	for(ItemDTO i:itemList)
		{	
			RestaurantDTO restaurantDTO=restaurantApi.showARestaurant(i.getRestaurantId());
			for(MenuDTO menuDTO:restaurantDTO.getMenuList()) {
				if(menuDTO.getItemName().equalsIgnoreCase(i.getItemName())) {
				i.setAmount(menuDTO.getPrice()*i.getQuantity());
				}
			}
		}
	for(ItemDTO i:itemList)
	{
		System.out.println(i);
	}
	ModelAndView mv=null;
	if(Finish==null) {
		mv= new ModelAndView("orderEntryPage2");
		mv.addObject("itemRecord", new ItemDTO());
		return mv;
	}
	else if(Next==null)
	{
		for(ItemDTO i:itemList)
		{
			itemN+=1L;
			i.setItemNo(itemN);
			total+=i.getAmount();
		}
		Double total1=total;
		Double dAmt=0.0;
		DecimalFormat df=new DecimalFormat("0.00");
		Double taxAmt=0.0;
		if(total<=500)
			throw new AmountException();
		if(total>=2500) {
			dAmt=total*2.5/100;
			total=total-((total*2.5)/100);
		}
		else if(total>=5000) {
			dAmt=total*5/100;
			total=total-((total*5)/100);
		}
		else if(total>=10000) {
			dAmt=total*10/100;
			total=total-((total*10)/100);
		}
		taxAmt=(0.125*total);
		total+=taxAmt;
		total+=total*0.1;
		String str=df.format(total);
		OrderAppDTO order=new OrderAppDTO();
		order.setOrderId(orderId);
		order.setClientId(clientId);
		order.setItemList(itemList);
		mv=new ModelAndView("showBillPage");
		mv.addObject("itemList",itemList);
		mv.addObject("total",total1);
		mv.addObject("totalAmt",str);
		mv.addObject("dAmt",dAmt);
		System.out.println(order);
		return mv;
	}
	return mv;
}


@GetMapping("/resume-order")
public ModelAndView showOrderIdEntryPage() {
	OrderAppDTO orderDTO =new OrderAppDTO();
	ModelAndView mv= new ModelAndView("orderIdEntryPage");
	mv.addObject("orderRecord",orderDTO); 
	return mv;
}

@PostMapping("/resume-order")
public ModelAndView resumePendingOrder(@ModelAttribute("orderRecord")OrderAppDTO orderAppDTO) {
	resumeOrderDto= orderApi.showAOrder(orderAppDTO.getOrderId());
	ModelAndView mv=null;
	Double total=0.0;
	for(ItemDTO i:resumeOrderDto.getItemList())
	{
		total+=i.getAmount();
	}
	Double total1=total;
	Double dAmt=0.0;
	DecimalFormat df=new DecimalFormat("0.00");
	Double taxAmt=0.0;
	if(total<=500)
		throw new AmountException();
	if(total>=2500) {
		dAmt=total*2.5/100;
		total=total-((total*2.5)/100);
	}
	else if(total>=5000) {
		dAmt=total*5/100;
		total=total-((total*5)/100);
	}
	else if(total>=10000) {
		dAmt=total*10/100;
		total=total-((total*10)/100);
	}
	taxAmt=(0.125*total);
	total+=taxAmt;
	total+=total*0.1;
	String str=df.format(total);
	mv=new ModelAndView("showBillPage2");
	mv.addObject("total",total1);
	mv.addObject("totalAmt",str);
	mv.addObject("dAmt",dAmt);
	mv.addObject("itemList",resumeOrderDto.getItemList());	
	return mv;
}

@PostMapping("/payment")
public ModelAndView showThankYouPage(@RequestParam("myradio") String stg) {
	CustomerDTO customerDTO=customerApi.showAcustomer(clientId);
	ModelAndView mv=null;
	if(stg.equalsIgnoreCase("credit") | stg.equalsIgnoreCase("net") | stg.equalsIgnoreCase("cash")) {
		mv=new ModelAndView("thankYouPage");
		customerDTO.setStatus("Cleared");
		for(ItemDTO item:itemList) {
		item.setOrderStatus("Delivered");
		item.setPayStatus("Paid");
		}
		}
	else if(stg.equalsIgnoreCase("payLater")) {
		customerDTO.setStatus("Pending");
		mv=new ModelAndView("redirect:/users/index");
	}
	OrderAppDTO order=new OrderAppDTO(orderId,clientId,itemList);
	orderApi.saveAOrder(order);
	customerApi.editCustomer(customerDTO);
	clientId=null;
	orderId=null;
	itemList.clear();
	System.out.println(order);
	return mv;
}

@PostMapping("/payment2")
public ModelAndView showThankYouPage2(@RequestParam("myradio") String stg) {
	CustomerDTO resumeCustomerDTO=customerApi.showAcustomer(resumeOrderDto.getClientId());
	ModelAndView mv=null;
	if(stg.equalsIgnoreCase("credit") | stg.equalsIgnoreCase("net") | stg.equalsIgnoreCase("cash")) {
		mv=new ModelAndView("thankYouPage");
		resumeCustomerDTO.setStatus("Cleared");
		for(ItemDTO item:resumeOrderDto.getItemList()) {
		item.setOrderStatus("Delivered");
		item.setPayStatus("Paid");
		}
		}
	orderApi.saveAOrder(resumeOrderDto);
	customerApi.editCustomer(resumeCustomerDTO);
	System.out.println(resumeOrderDto);
	return mv;
}


@GetMapping("/restaurantId-entry")
public ModelAndView showRestaurantIdEntryPage() {
	ItemDTO item=new ItemDTO();
	ModelAndView mv=new ModelAndView("restaurantIdEntryPage");
	mv.addObject("itemRecord",item);
	return mv;
}

@PostMapping("/restaurantId-entry")
public ModelAndView showCommissionPage(@ModelAttribute("itemRecord") ItemDTO item)
{
	Double commissionAmt= orderApi.generateCommission(item.getRestaurantId());
	ModelAndView mv=new ModelAndView("commissionShowPage");
	mv.addObject("Commission",commissionAmt);
	return mv;
}

@ExceptionHandler (value = AmountException.class)
public ModelAndView handlingFeeException (AmountException exception) {
String message="Sorry Total Amount should be greater than 500";
ModelAndView mv=new ModelAndView("errorShow") ;
mv.addObject ("errorMessage" ,message) ;
return mv;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@GetMapping("/customerOrder-entry")
public ModelAndView showCustomerOrderEntryPage() {
	OrderAppDTO orderDTO =new OrderAppDTO();
	ModelAndView mv= new ModelAndView("customerOrderEntryPage");
	mv.addObject("orderRecord",orderDTO); 
	return mv;
}

@PostMapping("/customerOrder-entry")
public ModelAndView showCustomerItemEntryPage(@RequestParam("clientId") Long cId)
{
	orderId=orderApi.generateId();
	ItemDTO itemDTO=new ItemDTO();
	clientId=cId;
	ModelAndView mv= new ModelAndView("customerOrderEntryPage2");
	mv.addObject("itemRecord",itemDTO);
	return mv;
}

@PostMapping("/customerItem-entry")
public ModelAndView showCustomerOrderEntryPage2(@ModelAttribute("itemRecord") ItemDTO itemDTO,@RequestParam(required = false,value="Next") String Next,@RequestParam(required = false,value="Finish") String Finish) {
	CustomerDTO customerDTO=customerApi.showAcustomer(clientId);
	Long itemN=orderApi.generateItemId();
	itemDTO.setOrderId(orderId);
	itemList.add(itemDTO);
	for(ItemDTO i:itemList)
		{	
			RestaurantDTO restaurantDTO=restaurantApi.showARestaurant(i.getRestaurantId());
			for(MenuDTO menuDTO:restaurantDTO.getMenuList()) {
				if(menuDTO.getItemName().equalsIgnoreCase(i.getItemName())) {
				i.setAmount(menuDTO.getPrice()*i.getQuantity());
				}
			}
		}
	ModelAndView mv=null;
	if(Finish==null) {
		mv= new ModelAndView("customerOrderEntryPage2");
		mv.addObject("itemRecord", new ItemDTO());
		return mv;
	}
	else if(Next==null)
	{
		for(ItemDTO i:itemList)
		{
			itemN+=1L;
			i.setItemNo(itemN);
		}
		OrderAppDTO order=new OrderAppDTO();
		order.setOrderId(orderId);
		order.setClientId(clientId);
		order.setItemList(itemList);
		customerDTO.setStatus("Pending");
		orderApi.saveAOrder(order);
		customerApi.editCustomer(customerDTO);
		mv=new ModelAndView("waitPage");
		return mv;
	}
	return mv;
}




























}
