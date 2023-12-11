package com.novel.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.novel.model.Product;
import com.novel.service.ProductService;
import com.novel.service.SequenceGenerator;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SequenceGenerator service;

	@PostMapping("/add")
	public ResponseEntity<String> addProducts(@Valid @RequestBody Product product) {
		product.setProductId(service.getSequenceNumber(Product.SEQUENCE_NAME));
		productService.addProducts(product);
		return ResponseEntity.ok("User is valid");

	}

	@GetMapping("/getproducts")
	public ResponseEntity<?> getAllProducts() {
		return ResponseEntity.ok(this.productService.getAllProducts());

	}

	@GetMapping("/getproducts/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") int productId) {

		Optional<Product> product = productService.getProductById(productId);
		if (!product.isPresent()) {
			// System.out.println("in get method " + product);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product.get(), HttpStatus.OK);
	}

	@GetMapping("/getproducts/type/{productType}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable("productType") String productType) {

		List<Product> product = productService.getProductByType(productType);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/getproducts/productName/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable("productName") String productName) {

		Optional<Product> product = productService.getProductByName(productName);
		if (!product.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product.get(), HttpStatus.OK);
	}

	@GetMapping("/getproducts/category/{category}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) {

		List<Product> product = productService.getProductByCategory(category);

		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PutMapping("/getproducts/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

		Product updatedProduct = productService.updateProducts(product);
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

	}

	@DeleteMapping("/getproducts/delete/{productId}")
	public int deleteProduct(@PathVariable("productId") int productId) {
		this.productService.deleteProductById(productId);
		return productId;
	}

}
