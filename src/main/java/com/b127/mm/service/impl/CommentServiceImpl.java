package com.b127.mm.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.entity.Comment;
import com.b127.mm.entity.User;
import com.b127.mm.repository.CommentRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getSellerComments(Long sellerId) {
		User seller = userRepository.findById(sellerId).get();
		return commentRepository.findBySeller(seller);
	}

	@Override
	public Comment addComment(Comment comment, Long sellerId) {
		User seller = userRepository.findById(sellerId).get();
		comment.setDate(LocalDate.now());
		comment.setTime(LocalTime.now());
		comment.setSeller(seller);
		return commentRepository.save(comment);
	}

	@Override
	public double getSellerRating(Long sellerId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
