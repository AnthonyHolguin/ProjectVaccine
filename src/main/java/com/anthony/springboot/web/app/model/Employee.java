package com.anthony.springboot.web.app.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

 

@Entity
@Table (name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee",columnDefinition = "serial")
	private Long idEmployee;
	@NotNull
	private String names;
	 
	@NotNull
	private String lastNames;
	
	@NotNull
	private String identificationCard;
	
	@NotNull
	private String email;

	private Date birthDate;
	
	private String homeAddress;
	 
	private String mobilePhone;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	private Users users;
	
	private boolean statusVaccine;
	
	
	@OneToOne(mappedBy = "employee")
	private Employee_vaccinated employee_vaccinated;
	
	public Employee() {
		 
		// TODO Auto-generated constructor stub
	}

	

	public Employee(Long idEmployee, @NotNull String names, @NotNull String lastNames,
			@NotNull String identificationCard, @NotNull String email, Date birthDate, String homeAddress,
			String mobilePhone, Users users, boolean statusVaccine, Employee_vaccinated employeeVaccinated) {
		super();
		this.idEmployee = idEmployee;
		this.names = names;
		this.lastNames = lastNames;
		this.identificationCard = identificationCard;
		this.email = email;
		this.birthDate = birthDate;
		this.homeAddress = homeAddress;
		this.mobilePhone = mobilePhone;
		this.users = users;
		this.statusVaccine = statusVaccine;
		this.employee_vaccinated = employeeVaccinated;
		
	}



	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(String identificationCard) {
		this.identificationCard = identificationCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public boolean isStatusVaccine() {
		return statusVaccine;
	}

	public void setStatusVaccine(boolean statusVaccine) {
		this.statusVaccine = statusVaccine;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}



	public Employee_vaccinated getEmployee_vaccinated() {
		return employee_vaccinated;
	} 



	public void setEmployee_vaccinated(Employee_vaccinated employee_vacinated) {
		this.employee_vaccinated = employee_vacinated;
	}

	
	
	
	
}
