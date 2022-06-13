package com.anthony.springboot.web.app.rest;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.springboot.web.app.exception.ErrorDetails;
import com.anthony.springboot.web.app.model.Employee;
import com.anthony.springboot.web.app.model.Employee_vaccinated;
import com.anthony.springboot.web.app.model.Users;
import com.anthony.springboot.web.app.services.EmployeeServices;
import com.anthony.springboot.web.app.services.EmployeeVaccinatedServices;
import com.anthony.springboot.web.app.services.UsersServices;

@RestController
@RequestMapping("/api/employee")
public class EmployeeREST {
	HttpServletRequest http;
	@Autowired
	private EmployeeServices employeeServices;
	@Autowired
	private UsersServices usersServices;
	@Autowired
	private EmployeeVaccinatedServices employeeVaccinatedServices;
	
	@PostMapping
	private ResponseEntity<?> save(HttpServletRequest http,@Validated @RequestBody Employee employee,BindingResult bindingResult){
		this.http = http;
		if(http.getSession().getAttribute("session")!=null) {
		if (bindingResult.hasErrors()) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(),"Error ", bindingResult.getAllErrors() );
			return new  ResponseEntity<>( errorDetails,HttpStatus.FORBIDDEN);
		}else if( http.getSession().getAttribute("session").equals("AD")){
			
		
		try {
			Users tempUser = usersServices.create(employee.getUsers());
			employee.setUsers(tempUser);
			Employee temp = employeeServices.create(employee);
			return ResponseEntity.created(new URI("/api/employee"+temp.getIdEmployee())).body(temp);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		}else {
			ErrorDetails errorDetails = new ErrorDetails(new Date(),"Error ", "Inicie sesion como usuario administrador" );
			return new  ResponseEntity<>( errorDetails,HttpStatus.FORBIDDEN);
		}
		}else {
			ErrorDetails errorDetails = new ErrorDetails(new Date(),"Error ", "Inicie sesion como usuario administrador" );
			return new  ResponseEntity<>( errorDetails,HttpStatus.FORBIDDEN);
		}
	}
	
	@PutMapping(value = "{idEmployee}")	
	private ResponseEntity<?> update(HttpServletRequest http,@Validated @RequestBody Employee employee,@PathVariable("idEmployee") Long idEmployee,BindingResult bindingResult){
		this.http = http;
		if(http.getSession().getAttribute("session")!=null) {
		if (bindingResult.hasErrors()) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(),"Error ", bindingResult.getAllErrors() );
			return new  ResponseEntity<>( errorDetails,HttpStatus.FORBIDDEN);
		}else if(http.getSession().getAttribute("session").equals("EM")){
			
		
		try {
			Employee employeeActual = employeeServices.finById2(idEmployee);
			employeeActual.setBirthDate(employee.getBirthDate());
			employeeActual.setHomeAddress(employee.getHomeAddress());
			employeeActual.setMobilePhone(employee.getMobilePhone());
			employeeActual.setStatusVaccine(employee.isStatusVaccine());
			
			if(employeeActual.isStatusVaccine()) {
				Employee_vaccinated tempEmployeeVaccinated2 = employeeActual.getEmployee_vaccinated();
				
				Employee tem2=  tempEmployeeVaccinated2.getEmployee();
				tem2.setIdEmployee(idEmployee);
				tempEmployeeVaccinated2.setEmployee(tem2);
				Employee_vaccinated tempEmployeeVaccinated = employeeVaccinatedServices.create(tempEmployeeVaccinated2);
			}
			Employee temp = employeeServices.create(employee);
			return ResponseEntity.created(new URI("/api/employee"+temp.getIdEmployee())).body(temp);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		}else {
			ErrorDetails errorDetails = new ErrorDetails(new Date(),"Error ", "Inicie sesion como usuario empleado" );
			return new  ResponseEntity<>( errorDetails,HttpStatus.FORBIDDEN);
		}
		}else {
			ErrorDetails errorDetails = new ErrorDetails(new Date(),"Error ", "Inicie sesion como usuario empleado" );
			return new  ResponseEntity<>( errorDetails,HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping
	private ResponseEntity<List<Employee>> listAllEmployees(){
		return ResponseEntity.ok(employeeServices.getAllEmployees());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> deleteEmploy(@RequestBody Employee employee){
		employeeServices.delete(employee);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "{idEmployee}")
	private ResponseEntity<Optional<Employee>> listEmployeebyId(@PathVariable("idEmployee") Long idEmployee){
		return ResponseEntity.ok(employeeServices.finById(idEmployee));
	}
	
}
