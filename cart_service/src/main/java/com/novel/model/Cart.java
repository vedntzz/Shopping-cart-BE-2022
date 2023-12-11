package com.novel.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cart")
public class Cart {
	
	@Transient // ignoring the field ( only work & doesnt save)
	public static final String SEQUENCE_NAME = "carts_sequence";
	
	@Id
	private int cartId;
	@NotNull
	private int productId;
	@NotBlank
	private String productName;
	@NotNull
	private int userId;
	@NotNull
	private int quantity;
	@NotNull
	private int price;
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart(int cartId, int productId, String productName, int userId, int quantity, int price) {
		this.cartId = cartId;
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
		this.quantity = quantity;
		this.price = price;
	}

	public Cart() {
		super();
	}
}
