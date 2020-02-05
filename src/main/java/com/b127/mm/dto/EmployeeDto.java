package com.b127.mm.dto;

import java.time.LocalDate;

import com.b127.mm.entity.SalaryType;

public class EmployeeDto {
	private Long id;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String nationalId;
	private String notes;
	private LocalDate workedSince;
	private SalaryType salaryType;
	private double salary;
	
	public EmployeeDto() {
		
	}

	public EmployeeDto(Long id, String name, String email, String mobile, String address, String nationalId,
			String notes, LocalDate workedSince, SalaryType salaryType, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.nationalId = nationalId;
		this.notes = notes;
		this.workedSince = workedSince;
		this.salaryType = salaryType;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getWorkedSince() {
		return workedSince;
	}

	public void setWorkedSince(LocalDate workedSince) {
		this.workedSince = workedSince;
	}

	public SalaryType getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(SalaryType salaryType) {
		this.salaryType = salaryType;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
}
