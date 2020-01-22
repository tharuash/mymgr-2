package com.b127.mm.service;

import java.util.List;

import com.b127.mm.entity.Stock;

public interface StockService {
	
	List<Stock> getSellerProductStocks(Long sellerId);
	
	Stock getProductStock(Long productId);
	
	Stock addProductStock(Stock stock, Long productId);
	
	void deleteStock(Long stockId);
}
