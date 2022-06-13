package com.anthony.springboot.web.app.repository;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anthony.springboot.web.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e "
			+ "	FROM employee as e \r\n"
			+ "	 where status_vaccine = true")
	Optional<Employee> filterByStatus();
	
	  
	  
	@Query("SELECT e "
			+ "	FROM employee as e \r\n"
			+ "	 join e.employee_vaccinated as ev  \r\n"
			
			+ "	 join ev.vaccine as v \r\n"
	 
			+ "	where v.id_vaccine=?1")
	Optional<Employee> filterByVaccine(Long id_vaccine);
	
	/*@Query("SELECT e "
			+ "	FROM employee as e \r\n"
			+ "	 join e.employee_vaccinated as ev  \r\n"
			
			+ "	 join ev.vaccine as v \r\n"
	 
			+ "	where ev.vaccination_date between ?1 and ?2")
	Optional<Employee> filterByVaccinationDate(Date date1,Date date2);*/

}
