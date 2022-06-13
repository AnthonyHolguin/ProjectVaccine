package com.anthony.springboot.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ProjectVaccineApplication implements CommandLineRunner  {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(ProjectVaccineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String v = "INSERT INTO public.vaccine(\n"
				+ "	id_vaccine, name, pharmaceutical)\n"
				+ "	VALUES (1, 'Sputnik V', 'Centro Nacional de Investigación de Epidemiología y Microbiología Gamaleya'),\n"
				+ "	(2, 'AstraZeneca', 'AstraZeneca plc'),\n"
				+ "	(3, 'Pfizer', 'Pfizer, Inc'),\n"
				+ "	(4, 'Jhonson&Jhonson', 'Jhonson&Jhonson')";
		String sql = "INSERT INTO public.users(\n"
				+ "	 password, type, user_name)\n"
				+ "	VALUES ( '1234', 'AD', 'ADMIN');";	
		int row = jdbcTemplate.update(sql);
		int n= jdbcTemplate.update(v);
		if(row>0) {
			System.out.print("New row");
		}
		if(n>0) {
			System.out.print("New vaccine");
		}
		
	}

}
