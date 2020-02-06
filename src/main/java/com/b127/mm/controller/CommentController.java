package com.b127.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b127.mm.entity.Comment;
import com.b127.mm.service.CommentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/{sellerId}")
	public List<Comment> getSellerComments(@PathVariable Long sellerId){
		return commentService.getSellerComments(sellerId);
	}
	
	@PostMapping("/{sellerId}")
	public Comment addComment(@RequestBody Comment comment, @PathVariable Long sellerId) {
		return commentService.addComment(comment, sellerId);
	}

}
