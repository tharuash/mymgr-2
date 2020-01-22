package com.b127.mm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.entity.Product;
import com.b127.mm.entity.User;
import com.b127.mm.repository.ProductRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getUserProducts(Long userId) {
		User currentSeller = userRepository.findById(userId).get();
		return productRepository.findByUser(currentSeller);
	}

	@Override
	public Product getOneProduct(Long productId) {
		return productRepository.findById(productId).get();
	}

	@Override
	public Product addProduct(Product product, Long userId) {
		User currentUser = userRepository.findById(userId).get();
		product.setUser(currentUser);
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}

	
	
}
