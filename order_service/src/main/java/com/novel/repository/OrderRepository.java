package com.novel.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.novel.model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {
	public List<Order> findByCustomerId(int customerId);
}
