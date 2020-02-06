package com.b127.mm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b127.mm.dto.LoginDto;
import com.b127.mm.dto.LoginResponseDto;
import com.b127.mm.entity.User;
import com.b127.mm.service.UserService;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/signin")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		//System.out.println(loginRequest.getUsername() + " " +loginRequest.getPassword());
		return ResponseEntity.accepted().body(userService.loginUser(loginDto));

	}

	@PostMapping(value = "/signup")
	public ResponseEntity<?> register(@RequestBody User user) {
		LoginResponseDto loginResponse = userService.registerUser(user);
		if (loginResponse != null) {
			// System.out.println("reg completed"+ loginResponse.getToken());
			return ResponseEntity.accepted().body(loginResponse);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping
	public String welcome() {
		return "Welcome you to my manager API. Go /products to see all product details.";
	}
}
