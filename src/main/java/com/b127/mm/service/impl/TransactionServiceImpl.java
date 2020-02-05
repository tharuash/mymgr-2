package com.b127.mm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.dto.EmployeeDto;
import com.b127.mm.dto.TransactionDto;
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

	/*@Override
	public Transaction getTransaction(Long transactionId) {
		return transactionRepository.findById(transactionId).get();
	}*/
	
	@Override
	public TransactionDto getTransaction(Long transactionId) {
		Transaction t = transactionRepository.findById(transactionId).get();
		return new TransactionDto(t.getId(), new EmployeeDto(t.getEmployee().getId(), t.getEmployee().getName(), "", "", "", "", "", null, null, 0), t.getTransactionType(),
				t.getTransactionDate(), t.getTransactionTime(),
				t.getAmount(), t.getDescription());
	}

	/*
	 * @Override public Transaction addTransaction(Transaction transaction, Long
	 * employeeId) { Employee selectedEmployee =
	 * employeeRepository.findById(employeeId).get();
	 * transaction.setEmployee(selectedEmployee); return
	 * transactionRepository.save(transaction); }
	 */

	@Override
	public TransactionDto addTransaction(Transaction transaction, Long employeeId) {
		Employee selectedEmployee = employeeRepository.findById(employeeId).get();
		transaction.setEmployee(selectedEmployee);
		Transaction savedTransaction = transactionRepository.save(transaction);
		return new TransactionDto(savedTransaction.getId(), savedTransaction.getTransactionType(),
				savedTransaction.getTransactionDate(), savedTransaction.getTransactionTime(),
				savedTransaction.getAmount(), savedTransaction.getDescription());
	}

	@Override
	public void deleteTransaction(Long transactionId) {
		transactionRepository.deleteById(transactionId);

	}

}
