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

import com.b127.mm.dto.ManualOrderDto;
import com.b127.mm.dto.OrderDto;
import com.b127.mm.dto.TransactionDto;
import com.b127.mm.entity.Transaction;
import com.b127.mm.service.OrderService;
import com.b127.mm.service.TransactionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/orders/{sellerId}")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/*@GetMapping
	public List<OrderDto> getSellerOrders(@PathVariable Long sellerId){
		return orderService.getSellerOrders(sellerId);
	}*/
	
	@GetMapping
	public List<ManualOrderDto> getSellerOrders(@PathVariable Long sellerId){
		return orderService.getSellerOrders(sellerId);
	}
	
	@GetMapping("/{orderId}")
	public ManualOrderDto getSellerOrder(@PathVariable Long orderId){
		return orderService.getSellerOrder(orderId);
	}
	
	
	
	/*@GetMapping("/{employeeId}")
	public List<Transaction> getEmployeeTransactions(@PathVariable Long employeeId) {
		return transactionService.getEmployeeTransactions(employeeId);
	}
	
	/*@GetMapping("/{employeeId}/{transactionId}")
	public Transaction getTransactions(@PathVariable Long transactionId) {
		return transactionService.getTransaction(transactionId);
	}
	
	@GetMapping("/{employeeId}/{transactionId}")
	public TransactionDto getTransactions(@PathVariable Long transactionId) {
		return transactionService.getTransaction(transactionId);
	}*/
	
	@PostMapping
	public ManualOrderDto addManualOrder(@RequestBody ManualOrderDto manualOrderDto , @PathVariable Long sellerId) {
		return orderService.addManualOrder(manualOrderDto, sellerId);
	}
	
	@PutMapping
	public ManualOrderDto updateManualOrder(@RequestBody ManualOrderDto manualOrderDto , @PathVariable Long sellerId) {
		return orderService.addManualOrder(manualOrderDto, sellerId);
	}
	
	/*@PostMapping("/{employeeId}")
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
	}*/

}
