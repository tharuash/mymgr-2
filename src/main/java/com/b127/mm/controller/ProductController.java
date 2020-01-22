package com.b127.mm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b127.mm.entity.Product;
import com.b127.mm.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/products/{sellerId}")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getSellerProducts(@PathVariable Long sellerId){
		return productService.getUserProducts(sellerId);
	}
	
	@GetMapping("/{productId}")
	public Product getSingleProduct(@PathVariable Long productId) {
		return productService.getOneProduct(productId);
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product, @PathVariable Long sellerId) {
		return productService.addProduct(product, sellerId);
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product, @PathVariable Long sellerId) {
		return productService.addProduct(product, sellerId);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
		productService.deleteProduct(productId);
		return ResponseEntity.ok().build();
	}
	
	

}
