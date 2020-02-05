package com.b127.mm.service;

import java.util.List;

import com.b127.mm.dto.TransactionDto;
import com.b127.mm.entity.Transaction;

public interface TransactionService {
	
	List<Transaction> getSellerTransactions(Long sellerId);
	
	List<Transaction> getEmployeeTransactions(Long employeeId);
	
	// Transaction getTransaction(Long transactionId);
	
	TransactionDto getTransaction(Long transactionId);
	
	// Transaction addTransaction(Transaction transaction, Long employeeId);
	
	TransactionDto addTransaction(Transaction transaction, Long employeeId);
	
	void deleteTransaction(Long transactionId);
	
}
