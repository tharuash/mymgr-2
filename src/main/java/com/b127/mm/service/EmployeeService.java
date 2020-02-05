package com.b127.mm.service;

import java.util.List;

import com.b127.mm.dto.EmployeeDto;
import com.b127.mm.entity.Employee;

public interface EmployeeService {
	List<Employee> getSellerEmployees(Long userId);
	
	// Employee getEmployee(Long employeeId);
	
	EmployeeDto getEmployee(Long employeeId);
	
	Employee addEmployee(Employee employee, Long userId);
	
	//Product updateProduct(Product product, Long userId);
	
	void deleteEmployee(Long employeeId);
}
