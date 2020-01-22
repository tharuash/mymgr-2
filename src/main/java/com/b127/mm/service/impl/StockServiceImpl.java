package com.b127.mm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.entity.Product;
import com.b127.mm.entity.Stock;
import com.b127.mm.entity.User;
import com.b127.mm.repository.ProductRepository;
import com.b127.mm.repository.StockRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stock> getSellerProductStocks(Long sellerId) {
		User currentSeller = userRepository.findById(sellerId).get();
		List<Product> sellerProducts = productRepository.findByUser(currentSeller);
		return stockRepository.findByProductIn(sellerProducts);
	}

	@Override
	public Stock getProductStock(Long productId) {
		Product selectedProduct = productRepository.findById(productId).get();
		return stockRepository.findByProduct(selectedProduct);
	}

	@Override
	public Stock addProductStock(Stock stock, Long productId) {
		Product selectedProduct = productRepository.findById(productId).get();
		stock.setProduct(selectedProduct);
		return stockRepository.save(stock);
	}

	@Override
	public void deleteStock(Long stockId) {
		stockRepository.deleteById(stockId);

	}

}
