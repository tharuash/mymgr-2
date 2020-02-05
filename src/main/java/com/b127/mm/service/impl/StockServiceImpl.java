package com.b127.mm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.dto.StockDto;
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
	public List<StockDto> getSellerProductStocks(Long sellerId) {
		User currentSeller = userRepository.findById(sellerId).get();
		List<Product> sellerProducts = productRepository.findByUser(currentSeller);
		List<Stock> sellerStocks = stockRepository.findByProductIn(sellerProducts);
		List<StockDto> stockDtos = new ArrayList<StockDto>();
		for (Stock s : sellerStocks) {
			stockDtos.add(new StockDto(s.getId(), s.getProduct().getName(), s.getStockType(), s.getMaximumQuantity(),
					s.getAvailableQuantity(), s.isAvailableOnSell(), s.getProduct().getUnitPrice()));
		}
		return stockDtos;
	}

	@Override
	public StockDto getProductStock(Long productId) {
		Product selectedProduct = productRepository.findById(productId).get();
		Stock s = stockRepository.findByProduct(selectedProduct);
		
		return new StockDto(s.getId(), s.getProduct().getName(), s.getStockType(), s.getMaximumQuantity(),
				s.getAvailableQuantity(), s.isAvailableOnSell(), 0.0);
	}

	@Override
	public StockDto addProductStock(Stock stock, Long productId) {
		Product selectedProduct = productRepository.findById(productId).get();
		stock.setProduct(selectedProduct);
		Stock s = stockRepository.save(stock);
		
		return new StockDto(s.getId(), s.getProduct().getName(), s.getStockType(), s.getMaximumQuantity(),
				s.getAvailableQuantity(), s.isAvailableOnSell(), 0.0);
	}

	@Override
	public void deleteStock(Long stockId) {
		stockRepository.deleteById(stockId);

	}

}
