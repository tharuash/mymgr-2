package com.b127.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.Comment;
import com.b127.mm.entity.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findBySeller(User seller);
}	
