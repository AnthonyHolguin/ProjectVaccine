package com.anthony.springboot.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="users")
@Table (name="users")
@NamedQuery(name="Users.findAll", query="SELECT u FROM users u")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user",columnDefinition = "serial")
	private Long id_user;
	 
	@NotNull
	private String user_name;
	
	@NotNull
	private String password;
	
	@NotNull
	private String type;
	 
	@OneToOne(mappedBy = "users")
	private Employee employee;
	 
	 

	public Users(Long id_user, @NotNull String user_name, @NotNull String password, @NotNull String type,
			Employee employee) {
		super();
		this.id_user = id_user;
		this.user_name = user_name;
		this.password = password;
		this.type = type;
		this.employee = employee;
	}
	
	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
