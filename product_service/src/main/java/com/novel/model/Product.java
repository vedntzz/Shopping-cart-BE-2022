package com.novel.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Product {
	
	@Transient
	public static final String SEQUENCE_NAME = "products_sequence";
	
	@Id
	private int productId;
	@NotBlank
	private String productType;
	@NotBlank
	private String productName;
	@NotBlank
	private String category;
	@NotBlank
	private String rating;
	@NotBlank
	private String review;
	@NotBlank
	private String image;
	@NotBlank
	private String price;
	@NotBlank
	private String description;
	@NotBlank
	private String specification;
	
	public Product(int productId, String productType, String productName, String category, String rating, String review, String image, String price, String description, String specification)
	{
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.review = review;
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}
	public Product() {
		}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productType='" + productType + '\'' +
				", productName='" + productName + '\'' +
				", category='" + category + '\'' +
				", rating=" + rating +
				", review=" + review +
				", image=" + image +
				", price=" + price +
				", description='" + description + '\'' +
				", specification=" + specification +
				'}';
	}
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}



}
