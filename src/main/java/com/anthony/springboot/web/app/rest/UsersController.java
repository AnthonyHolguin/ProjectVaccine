package com.anthony.springboot.web.app.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.springboot.web.app.exception.ErrorDetails;
import com.anthony.springboot.web.app.model.Employee;
import com.anthony.springboot.web.app.model.Users;
import com.anthony.springboot.web.app.services.UsersServices;

@RestController
@RequestMapping("/login")
public class UsersController {
	HttpServletRequest http;
	@Autowired 
	UsersServices usersServices;
	
	@PostMapping
	public ResponseEntity<?> login(HttpServletRequest http,@RequestParam String username, @RequestParam String password){
		List<Users> users = usersServices.findUserByUserNamePassword(username, password);
		this.http = http;
		if(users==null) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(),"Error ", "Usuario o contraseña incorrectos" );
			return new  ResponseEntity<>( errorDetails,HttpStatus.FORBIDDEN);
		}else {
			http.getSession().setAttribute("session", users.get(0).getType());
		return ResponseEntity.ok(users);
		}
	}

}
