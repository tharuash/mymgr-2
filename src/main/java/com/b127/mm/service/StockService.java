package com.b127.mm.service;

import java.util.List;

import com.b127.mm.dto.StockDto;
import com.b127.mm.entity.Stock;

public interface StockService {
	
	List<StockDto> getSellerProductStocks(Long sellerId);
	
	StockDto getProductStock(Long productId);
	
	StockDto addProductStock(Stock stock, Long productId);
	
	void deleteStock(Long stockId);
}
