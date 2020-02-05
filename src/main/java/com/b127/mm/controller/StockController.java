package com.b127.mm.controller;

import java.util.List;

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

import com.b127.mm.dto.StockDto;
import com.b127.mm.entity.Stock;
import com.b127.mm.service.StockService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/products/stocks/{sellerId}")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping
	public List<StockDto> getSellerProductStocks(@PathVariable Long sellerId){
		return stockService.getSellerProductStocks(sellerId);
	}
	
	@GetMapping("/{productId}")
	public StockDto getProductStock(@PathVariable Long productId) {
		return stockService.getProductStock(productId);
	}
	
	@PostMapping("/{productId}")
	public StockDto addProductStock(@RequestBody Stock stock, @PathVariable Long productId) {
		return stockService.addProductStock(stock, productId);
	}
	
	@PutMapping("/{productId}")
	public StockDto updateProductStock(@RequestBody Stock stock, @PathVariable Long productId) {
		return stockService.addProductStock(stock, productId);
	}
	
	@DeleteMapping("/{stockId}")
	public ResponseEntity<?> deleteStock(@PathVariable Long stockId){
		stockService.deleteStock(stockId);
		return ResponseEntity.ok().build();
	}

}
