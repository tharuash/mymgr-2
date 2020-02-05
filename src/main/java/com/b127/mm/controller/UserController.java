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

import com.b127.mm.entity.User;
import com.b127.mm.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long userId){
		userService.deleteUser(userId);
		return ResponseEntity.ok().build();
	}

}
