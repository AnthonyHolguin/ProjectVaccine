package com.anthony.springboot.web.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.anthony.springboot.web.app.model.Employee_vaccinated;
import com.anthony.springboot.web.app.repository.EmployeeVaccinatedRepository;

@Service
public class EmployeeVaccinatedServices {
	
	@Autowired
	EmployeeVaccinatedRepository employeeVaccinatedRepository;
	
	public Employee_vaccinated create(Employee_vaccinated employeeVaccinated) {
		return employeeVaccinatedRepository.save(employeeVaccinated);
	}
	
	public List<Employee_vaccinated> getAllEmployees(){
		return employeeVaccinatedRepository.findAll();
	}
	
	public void delete (Employee_vaccinated employee) {
		employeeVaccinatedRepository.delete(employee);
	}
	
	
	public Optional<Employee_vaccinated> finById(Long id) {
		return employeeVaccinatedRepository.findById(id);
	}
	
	public Employee_vaccinated finById2(Long id) {
		return employeeVaccinatedRepository.findById(id).orElse(null);
	}

}
