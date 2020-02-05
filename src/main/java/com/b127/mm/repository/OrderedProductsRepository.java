package com.b127.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.OrderedProducts;
import com.b127.mm.entity.Product;

@Repository
public interface OrderedProductsRepository extends JpaRepository<OrderedProducts, Long> {
	
	List<OrderedProducts> findByProduct(Product product);
	
	@Query(value = "SELECT EXTRACT('month' FROM o.order_start_date) AS month, SUM(op.required_quantity) AS amount FROM ordered_products op INNER JOIN orders o ON op.order_id = o.id AND op.product_id = :productId GROUP BY month", nativeQuery = true)
	List<Object> findProductSells(@Param("productId") Long productId);
}
