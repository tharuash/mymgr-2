package com.b127.mm.service;

import java.util.List;

import com.b127.mm.dto.LoginDto;
import com.b127.mm.dto.LoginResponseDto;
import com.b127.mm.entity.User;

public interface UserService {
	List<User> getUsers();
	
	User getUser(Long userId);
	
	User addUser(User user);
	
	//Product updateProduct(Product product, Long userId);
	
	LoginResponseDto loginUser(LoginDto loginDto);
	
	LoginResponseDto registerUser(User user);
	
	void deleteUser(Long userId);
}
