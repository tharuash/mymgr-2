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

import com.b127.mm.dto.OrderDto;
import com.b127.mm.dto.ProductDto;
import com.b127.mm.dto.ProductOrderDto;
import com.b127.mm.entity.Product;
import com.b127.mm.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<ProductDto> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/buy/{productId}")
	public ProductDto getProduct(@PathVariable Long productId) {
		return productService.getProduct(productId);
	}
	
	@GetMapping("/{sellerId}")
	public List<ProductDto> getSellerProducts(@PathVariable Long sellerId){
		return productService.getUserProducts(sellerId);
	}
	
	@GetMapping("/{sellerId}/req")
	public List<ProductDto> getSellerRequiredProducts(@RequestBody List<Long> productIds, @PathVariable Long sellerId){
		return productService.getUserRequiredProducts(productIds);
	}
	
	/*@GetMapping("/{productId}")
	public Product getSingleProduct(@PathVariable Long productId) {
		return productService.getOneProduct(productId);
	}*/
	
	@GetMapping("/{sellerId}/{productId}")
	public ProductDto getSingleProduct(@PathVariable Long productId) {
		return productService.getOneProduct(productId);
	}
	
	/*@PostMapping
	public Product addProduct(@RequestParam("product") String productDetails, @RequestParam("image") MultipartFile file, @PathVariable Long sellerId) throws JsonMappingException, JsonProcessingException {
		return productService.addProductNew(productDetails,file, sellerId);
	}*/
	
	@PostMapping("/{sellerId}")
	public Product addProduct(@RequestBody Product product, @PathVariable Long sellerId) throws JsonMappingException, JsonProcessingException {
		System.out.println(product.getName());
		return productService.addProduct(product, sellerId);
	}
	
	@PutMapping("/{sellerId}")
	public Product updateProduct(@RequestBody Product product, @PathVariable Long sellerId) {
		return productService.addProduct(product, sellerId);
	}
	
	@DeleteMapping("/{sellerId}/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
		productService.deleteProduct(productId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{sellerId}/{productId}/orders")
	public List<ProductOrderDto> getProductOrders(@PathVariable Long productId) {
		return productService.getProductOrders(productId);
	}

}
