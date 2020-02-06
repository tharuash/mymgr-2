package com.b127.mm.dto;

import com.b127.mm.entity.User;

public class LoginResponseDto {
	
	private User user;
	private String token;

	public LoginResponseDto() {

	}

	public LoginResponseDto(User user, String token) {
		this.user = user;
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
