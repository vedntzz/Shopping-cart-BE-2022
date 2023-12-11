package com.novel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.novel.model.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer>{
	public Cart getCartByUserId(int cartId);
}
