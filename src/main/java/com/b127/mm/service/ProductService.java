package com.b127.mm.service;

import java.util.List;

import com.b127.mm.dto.ProductDto;
import com.b127.mm.dto.ProductOrderDto;
import com.b127.mm.entity.Product;

public interface ProductService {
	// List<Product> getUserProducts(Long userId);
	
	List<ProductDto> getUserProducts(Long userId);
	
	List<ProductDto> getUserRequiredProducts(List<Long> productIds);

	// Product getOneProduct(Long productId);
	
	ProductDto getOneProduct(Long productId);

	Product addProduct(Product product, Long userId);

	// Product updateProduct(Product product, Long userId);

	void deleteProduct(Long productId);

	// Product addProductNew(String productData, MultipartFile file, Long userId)
	// throws JsonMappingException, JsonProcessingException;
	
	List<ProductOrderDto> getProductOrders(Long productId);
}
