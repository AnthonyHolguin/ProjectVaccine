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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

 

@Entity(name = "employee")
@Table (name="employee") 
@NamedQuery(name="Employee.findAll", query="SELECT e FROM employee e")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee",columnDefinition = "serial")
	private Long id_employee;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z]+", message="El nombre solo puede tener letras")
	@NotBlank(message="El nombre de usuario no puede estar vacío")
	private String names;
	 
	@NotNull
	@Column(name = "last_names")
	@Pattern(regexp = "[A-Za-z]+", message="El apellido solo puede tener letras")
	@NotBlank(message="El apellido de usuario no puede estar vacío")
	private String lastNames;
	
	@NotNull
	@Column(name = "identification_card")
	@Size(min = 10, max=10, message = "La cedula debe tener 10 digitos")
	@Pattern(regexp="[0-9]+",message="Cedula incorrecta")
	private String identificationCard;
	
	@NotNull
	@Email(message = "El formato de corrreo no es válido." )
	private String email;

	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "home_address")
	private String homeAddress;
	 
	@Column(name = "mobile_phone")
	private String mobilePhone;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	private Users users;
	
	@Column(name = "status_vaccine")
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
		this.id_employee = idEmployee;
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
		return id_employee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.id_employee = idEmployee;
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
