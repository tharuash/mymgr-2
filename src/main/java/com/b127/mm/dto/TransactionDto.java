package com.b127.mm.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.b127.mm.entity.Employee;
import com.b127.mm.entity.TransactionType;

public class TransactionDto {
	private Long id; 
	private EmployeeDto employee;
	private TransactionType transactionType;
	private LocalDate transactionDate;
	private LocalTime transactionTime;
	private double amount;
	private String description;
	
	public TransactionDto() {
		
	}

	public TransactionDto(Long id, TransactionType transactionType, LocalDate transactionDate,
			LocalTime transactionTime, double amount, String description) {
		super();
		this.id = id;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.amount = amount;
		this.description = description;
	}
	
	

	public TransactionDto(Long id, EmployeeDto employeeDto, TransactionType transactionType, LocalDate transactionDate,
			LocalTime transactionTime, double amount, String description) {
		super();
		this.id = id;
		this.employee = employeeDto;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	
	public EmployeeDto getEmployee() {
		return employee;
	}
	
	
}
