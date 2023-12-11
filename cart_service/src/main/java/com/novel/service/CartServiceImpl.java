package com.novel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novel.model.Cart;
import com.novel.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart getCartByUserId(int cartId) {
		return this.cartRepository.getCartByUserId(cartId);
	}

	@Override
	public void deleteById(int cartId) {
		this.cartRepository.deleteById(cartId);
	}

	@Override
	public Cart addCart(Cart cart) {
		return this.cartRepository.save(cart);
	}

	@Override
	public Cart getCartByProductId(int productId) {
		return this.cartRepository.findById(productId).get();
	}

	@Override
	public List<Cart> getAllCart() {
		return this.cartRepository.findAll();
	}
}
