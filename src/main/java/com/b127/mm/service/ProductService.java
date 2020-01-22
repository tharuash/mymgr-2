package com.b127.mm.service;

import java.util.List;

import com.b127.mm.entity.Product;

public interface ProductService {
	List<Product> getUserProducts(Long userId);
	
	Product getOneProduct(Long productId);
	
	Product addProduct(Product product, Long userId);
	
	//Product updateProduct(Product product, Long userId);
	
	void deleteProduct(Long productId);
}
