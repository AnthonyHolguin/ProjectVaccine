package com.anthony.springboot.web.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthony.springboot.web.app.model.Employee;
import com.anthony.springboot.web.app.repository.EmployeeRepository;

@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee create (Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public void delete (Employee employee) {
		 employeeRepository.delete(employee);
	}
	
	
	public Optional<Employee> finById(Long id) {
		return employeeRepository.findById(id);
	}
	
	public Employee finById2(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
}

