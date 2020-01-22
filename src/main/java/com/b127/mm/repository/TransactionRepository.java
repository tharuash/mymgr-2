package com.b127.mm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b127.mm.entity.Employee;
import com.b127.mm.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findByEmployeeIn(List<Employee> employees);
	
	List<Transaction> findByEmployee(Employee employee);
}
