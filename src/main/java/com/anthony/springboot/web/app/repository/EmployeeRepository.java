package com.anthony.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anthony.springboot.web.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
/*	@Query("SELECT e.id_employee, birth_date, email, home_address, identification_card, last_names, mobile_phone, names, status_vaccine\r\n"
			+ "	FROM employee as e \r\n"
			+ "	inner join employee_vaccinated as ev on \r\n"
			+ "	ev.id_employee = ev.id_employee\r\n"
			+ "	inner join vaccine as v on\r\n"
			+ "	v.id_vaccine = ev.id_vaccine\r\n"
			+ "	where status_vaccine = true")
	Employee filterByStatus();
	
	/*@Query("SELECT e.id_employee, birth_date, email, home_address, identification_card, last_names, mobile_phone, names, status_vaccine\r\n"
			+ "	FROM employee as e \r\n"
			+ "	inner join employee_vaccinated as ev on \r\n"
			+ "	ev.id_employee = ev.id_employee\r\n"
			+ "	inner join vaccine as v on\r\n"
			+ "	v.id_vaccine = ev.id_vaccine\r\n"
			+ "	where status_vaccine = true and v.id_vaccine=?1")
	Employee filterByVaccine(String id_vaccine);
	
	@Query("SELECT e.id_employee, birth_date, email, home_address, identification_card, last_names, mobile_phone, names, status_vaccine\r\n"
			+ "	FROM employee as e \r\n"
			+ "	inner join employee_vaccinated as ev on \r\n"
			+ "	ev.id_employee = ev.id_employee\r\n"
			+ "	inner join vaccine as v on\r\n"
			+ "	v.id_vaccine = ev.id_vaccine\r\n"
			+ "	where status_vaccine = true and ev.vaccination_date between ?1 and ?2")
	Employee filterByVaccinationDate(String date1,String date2);*/

}
