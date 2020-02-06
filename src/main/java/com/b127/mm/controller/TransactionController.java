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

import com.b127.mm.dto.TransactionDto;
import com.b127.mm.entity.Transaction;
import com.b127.mm.service.TransactionService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/employees/transactions/{sellerId}")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping
	public List<Transaction> getSellerTransactions(@PathVariable Long sellerId){
		return transactionService.getSellerTransactions(sellerId);
	}
	
	@GetMapping("/{employeeId}")
	public List<TransactionDto> getEmployeeTransactions(@PathVariable Long employeeId) {
		return transactionService.getEmployeeTransactions(employeeId);
	}
	
	/*@GetMapping("/{employeeId}/{transactionId}")
	public Transaction getTransactions(@PathVariable Long transactionId) {
		return transactionService.getTransaction(transactionId);
	}*/
	
	@GetMapping("/{employeeId}/{transactionId}")
	public TransactionDto getTransactions(@PathVariable Long transactionId) {
		return transactionService.getTransaction(transactionId);
	}
	
	/*@PostMapping("/{employeeId}")
	public Transaction addTransaction(@RequestBody Transaction transaction, @PathVariable Long employeeId) {
		return transactionService.addTransaction(transaction, employeeId);
	}*/
	
	@PostMapping("/{employeeId}")
	public TransactionDto addTransaction(@RequestBody Transaction transaction, @PathVariable Long employeeId) {
		return transactionService.addTransaction(transaction, employeeId);
	}
	
	@PutMapping("/{employeeId}")
	public TransactionDto updateTransaction(@RequestBody Transaction transaction, @PathVariable Long employeeId) {
		return transactionService.addTransaction(transaction, employeeId);
	}
	
	@DeleteMapping("/{employeeId}/{transactionId}")
	public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId){
		transactionService.deleteTransaction(transactionId);
		return ResponseEntity.ok().build();
	}

}
