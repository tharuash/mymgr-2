package com.b127.mm.service;

import java.util.List;

import com.b127.mm.entity.Comment;

public interface CommentService {
	
	List<Comment> getSellerComments(Long sellerId);
	
	Comment addComment(Comment comment, Long sellerId);
	
	double getSellerRating(Long sellerId);
}
