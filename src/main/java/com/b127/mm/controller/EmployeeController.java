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

import com.b127.mm.entity.Employee;
import com.b127.mm.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/employees/{sellerId}")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getSellerEmployees(@PathVariable Long sellerId){
		return employeeService.getSellerEmployees(sellerId);
	}
	
	@GetMapping("/{employeeId}")
	public Employee getSingleEmployee(@PathVariable Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee, @PathVariable Long sellerId) {
		return employeeService.addEmployee(employee, sellerId);
	}
	
	@PutMapping
	public Employee updateProduct(@RequestBody Employee employee, @PathVariable Long sellerId) {
		return employeeService.addEmployee(employee, sellerId);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok().build();
	}
}
