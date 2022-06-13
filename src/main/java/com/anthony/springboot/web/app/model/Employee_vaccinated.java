package com.anthony.springboot.web.app.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="employee_vaccinated")
@Table (name="employee_vaccinated")
@NamedQuery(name="EmployeeVaccinated.findAll", query="SELECT ev FROM employee_vaccinated ev")
public class Employee_vaccinated {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee_vaccinated",columnDefinition = "serial")
	private Long id_employee_vaccinated;
	
	@NotNull
	private int dose;
	
	@NotNull
	private Date vaccinationDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_vaccine", referencedColumnName = "id_vaccine")
	private Vaccine vaccine; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
	private Employee employee;

	
	public Employee_vaccinated() {
		 
		// TODO Auto-generated constructor stub
	}

	public Employee_vaccinated(Long id_employee_vaccinated, @NotNull int dose, @NotNull Date vaccinationDate,
			Vaccine vaccine, Employee employee) {
		super();
		this.id_employee_vaccinated = id_employee_vaccinated;
		this.dose = dose;
		this.vaccinationDate = vaccinationDate;
		this.vaccine = vaccine;
		this.employee = employee;
	}

	public Long getId_employee_vaccinated() {
		return id_employee_vaccinated;
	}

	public void setId_employee_vaccinated(Long id_employee_vaccinated) {
		this.id_employee_vaccinated = id_employee_vaccinated;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	

}
