package com.b127.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.Product;
import com.b127.mm.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	List<Stock> findByProductIn(List<Product> products);
	
	Stock findByProduct(Product product);
}
