package com.b127.mm.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.entity.Role;
import com.b127.mm.entity.RoleName;
import com.b127.mm.entity.User;
import com.b127.mm.repository.RoleRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
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

}
