package com.b127.mm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.entity.Employee;
import com.b127.mm.entity.Transaction;
import com.b127.mm.entity.User;
import com.b127.mm.repository.EmployeeRepository;
import com.b127.mm.repository.TransactionRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	 
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Transaction> getSellerTransactions(Long sellerId) {
		User currentSeller = userRepository.findById(sellerId).get();
		List<Employee> sellerEmployees = employeeRepository.findByUser(currentSeller);
		return transactionRepository.findByEmployeeIn(sellerEmployees);
	}

	@Override
	public List<Transaction> getEmployeeTransactions(Long employeeId) {
		Employee sellectedEmployee = employeeRepository.findById(employeeId).get();
		return transactionRepository.findByEmployee(sellectedEmployee);
	}

	@Override
	public Transaction getTransaction(Long transactionId) {
		return transactionRepository.findById(transactionId).get();
	}

	@Override
	public Transaction addTransaction(Transaction transaction, Long employeeId) {
		Employee selectedEmployee = employeeRepository.findById(employeeId).get();
		transaction.setEmployee(selectedEmployee);
		return transactionRepository.save(transaction);
	}

	@Override
	public void deleteTransaction(Long transactionId) {
		transactionRepository.deleteById(transactionId);
		
	}
	
	
}
