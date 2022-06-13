package com.anthony.springboot.web.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthony.springboot.web.app.model.Employee;
import com.anthony.springboot.web.app.model.Vaccine;
import com.anthony.springboot.web.app.repository.VaccineRepository;

@Service
public class VaccineServices {
	
	@Autowired
	VaccineRepository vaccineRepository;
	
	public Vaccine create(Vaccine vaccine) {
		return vaccineRepository.save(vaccine);
	}
	
	public Vaccine finById(Long id) {
		return vaccineRepository.findById(id).orElse(null);
	}
}
