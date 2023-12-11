package com.novel.service;

import java.util.List;

import com.novel.model.Address;
import com.novel.model.Order;
public interface OrderService {
	public Order addOrder(Order order);

	public List<Order> getAllOrders();

	public void deleteOrder(int orderId);

	public List<Order> getOrderByCustomerId(int customerId);

	public List<Address> getAddressByCustomerId(int customerId);

	public Order getOrderById(int orderId);
}
 