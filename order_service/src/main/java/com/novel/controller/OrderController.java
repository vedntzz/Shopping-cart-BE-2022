package com.novel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novel.model.Address;
import com.novel.model.Order;
 import com.novel.service.OrderService;
import com.novel.service.SequenceGenerator;
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private SequenceGenerator service;
	
	@PostMapping("/addorder")
	public ResponseEntity<String> addOrder(@Valid @RequestBody Order order) {
		order.setOrderId(service.getSequenceNumber(Order.SEQUENCE_NAME));
		orderService.addOrder(order);
		return ResponseEntity.ok("User is valid");
	}

	@GetMapping("/getorders")
	public ResponseEntity<?>  getAllOrder(){
		return ResponseEntity.ok(this.orderService.getAllOrders());
	}

	@GetMapping("/getorders/{orderId}")
	public Order getOrderById(@PathVariable("orderId") int orderId) {
		return this.orderService.getOrderById(orderId);
	}

	@GetMapping("/getorders/ordercustid/{customerId}")
	public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable("customerId") int customerId) {
		List<Order> order = orderService.getOrderByCustomerId(customerId);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@GetMapping("/getorders/address/{customerId}")
	public ResponseEntity<List<Address>> getAddressByCustomerId(@PathVariable("customerId") int customerId) {
		List<Address> address = orderService.getAddressByCustomerId(customerId);
		return new ResponseEntity<>(address, HttpStatus.OK);
	}

	@DeleteMapping("/getorders/delete/{orderId}")
	public int deleteOrderById(@PathVariable("orderId") int orderId) {
		this.orderService.deleteOrder(orderId);
		return orderId;
	}

}
