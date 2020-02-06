package com.b127.mm.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.b127.mm.dto.LoginDto;
import com.b127.mm.dto.LoginResponseDto;
import com.b127.mm.entity.Role;
import com.b127.mm.entity.RoleName;
import com.b127.mm.entity.User;
import com.b127.mm.repository.RoleRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.security.JwtProvider;
import com.b127.mm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public User addUser(User user) {
		Set<Role> roles = user.getRoles();
		List<RoleName> roleNames = new ArrayList<RoleName>();
		
		for(Role r : roles) {
			if(!roleRepository.existsByName(r.getName())) {
				roleRepository.save(r);
			}
			
			roleNames.add(r.getName());
		}
		
		List<Role> userRoles = roleRepository.findByNameIn(roleNames);
		Set<Role> userRoleSet = new HashSet<>();
		
		for(Role r: userRoles) {
			userRoleSet.add(r);
		}
		
		user.setRoles(userRoleSet);
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public LoginResponseDto loginUser(LoginDto loginDto) {
		LoginResponseDto loginResponseDto;

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		User currentUser = userRepository.findByUsername(loginDto.getUsername()).get();

		loginResponseDto = new LoginResponseDto(currentUser, jwt);

		return loginResponseDto;
	}

	@Override
	public LoginResponseDto registerUser(User user) {
		if (!(userRepository.existsByUsername(user.getUsername()) || userRepository.existsByEmail(user.getEmail()))) {

			Set<Role> roles = user.getRoles();
			List<RoleName> names = new ArrayList<>();
			
			for(Role r : roles) {
				if (!(roleRepository.existsByName(r.getName()))) {

					roleRepository.save(r);
				}
				
				names.add(r.getName());
				
			}
				
			List<Role> userRoles = roleRepository.findByNameIn(names);
			
			Set<Role> userRolesSet = new HashSet<>(userRoles);
			user.setRoles(userRolesSet);
			
			
			String password = user.getPassword();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User savedUser = userRepository.save(user);

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtProvider.generateToken(authentication);

			LoginResponseDto loginResponse = new LoginResponseDto(savedUser, jwt);

			return loginResponse;
		} else {
			return null;
		}
	}

}
