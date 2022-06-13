package com.anthony.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anthony.springboot.web.app.model.Employee_vaccinated;

public interface EmployeeVaccinatedRepository extends JpaRepository<Employee_vaccinated, Long> {

}
