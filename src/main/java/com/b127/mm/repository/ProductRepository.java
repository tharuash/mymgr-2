package com.b127.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.Product;
import com.b127.mm.entity.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByUser(User user);

}
