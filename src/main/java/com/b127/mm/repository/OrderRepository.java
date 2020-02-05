package com.b127.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.Order;
import com.b127.mm.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findBySeller(User seller);
}
