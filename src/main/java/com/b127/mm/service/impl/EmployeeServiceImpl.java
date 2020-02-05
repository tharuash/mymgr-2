package com.b127.mm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.mm.dto.EmployeeDto;
import com.b127.mm.entity.Employee;
import com.b127.mm.entity.User;
import com.b127.mm.repository.EmployeeRepository;
import com.b127.mm.repository.UserRepository;
import com.b127.mm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getSellerEmployees(Long userId) {
		User currentSeller = userRepository.findById(userId).get();
		return employeeRepository.findByUser(currentSeller);
	}

	/*
	 * @Override public Employee getEmployee(Long employeeId) { return
	 * employeeRepository.findById(employeeId).get(); }
	 */

	@Override
	public EmployeeDto getEmployee(Long employeeId) {
		Employee e = employeeRepository.findById(employeeId).get();
		return new EmployeeDto(e.getId(), e.getName(), e.getEmail(), e.getMobile(), e.getAddress(), e.getNationalId(),
				e.getNotes(), e.getWorkedSince(), e.getSalaryType(), e.getSalary());
	}

	@Override
	public Employee addEmployee(Employee employee, Long userId) {
		User currentUser = userRepository.findById(userId).get();
		employee.setUser(currentUser);
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
