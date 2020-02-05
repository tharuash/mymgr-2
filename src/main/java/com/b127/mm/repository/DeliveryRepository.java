package com.b127.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.Delivery;
import com.b127.mm.entity.Order;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	
	Delivery findByOrder(Order order);
	
	List<Delivery> findByOrderIn(List<Order> orders);

}
