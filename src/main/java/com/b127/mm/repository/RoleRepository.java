package com.b127.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.Role;
import com.b127.mm.entity.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByName(RoleName name);
	
	boolean existsByName(RoleName name);
	
	List<Role> findByNameIn(List<RoleName> names);
}
