package com.b127.mm.service;

import java.util.List;

import com.b127.mm.entity.User;

public interface UserService {
	List<User> getUsers();
	
	User getUser(Long userId);
	
	User addUser(User user);
	
	//Product updateProduct(Product product, Long userId);
	
	void deleteUser(Long userId);
}
