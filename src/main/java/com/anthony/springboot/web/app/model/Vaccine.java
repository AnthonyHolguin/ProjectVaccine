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

@Entity(name="vaccine")
@Table (name="vaccine")
@NamedQuery(name="Vaccine.findAll", query="SELECT v FROM vaccine v")
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vaccine",columnDefinition = "serial")
	private Long id_vaccine;
	
	@NotNull
	private String name;
	
	@NotNull
	private String pharmaceutical;
	
	

	@OneToOne(mappedBy = "vaccine")
	private Employee_vaccinated employee_vacinated;
	
	public Vaccine(Long idVaccine, @NotNull String name, @NotNull String pharmaceutical) {
		super();
		this.id_vaccine = idVaccine;
		this.name = name;
		this.pharmaceutical = pharmaceutical;
	}
	
	

	public Vaccine() {


		// TODO Auto-generated constructor stub
	}

	

	public Long getIdVaccine() {
		return id_vaccine;
	}

	public void setIdVaccine(Long idVaccine) {
		this.id_vaccine = idVaccine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPharmaceutical() {
		return pharmaceutical;
	}

	public void setPharmaceutical(String pharmaceutical) {
		this.pharmaceutical = pharmaceutical;
	}


	
	

}
