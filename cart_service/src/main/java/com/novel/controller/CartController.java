package com.novel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.novel.model.Cart;
import com.novel.service.CartService;
import com.novel.service.SequenceGenerator;

@RestController
@RequestMapping("/cart")
public class CartController  {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private SequenceGenerator service;

	@PostMapping("/add")
	public ResponseEntity<String> addCartById(@Valid @RequestBody Cart cart) {
		cart.setCartId(service.getSequenceNumber(Cart.SEQUENCE_NAME));
		cartService.addCart(cart);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<?> getAllCart(){
		return ResponseEntity.ok(this.cartService.getAllCart());
	}

	@GetMapping("/get/user/{userid}")
	public Cart getCartByUserId(@PathVariable("userid") int userId) {
		return this.cartService.getCartByUserId(userId);
	}

	@GetMapping("/get/{cartId}")
	public Cart getCartById(@PathVariable("cartId") int cartId) {
		return this.cartService.getCartByProductId(cartId);
	}

	@DeleteMapping("get/del/{cartId}")
	public int deleteById(@PathVariable("cartId") int cartId) {
		this.cartService.deleteById(cartId);
		return cartId;
	}
}
