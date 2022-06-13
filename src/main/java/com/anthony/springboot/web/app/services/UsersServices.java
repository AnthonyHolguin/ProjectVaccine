package com.anthony.springboot.web.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthony.springboot.web.app.model.Employee;
import com.anthony.springboot.web.app.model.Users;
import com.anthony.springboot.web.app.repository.UsersRepository;

@Service
public class UsersServices {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public Users create (Users users) {
		return usersRepository.save(users);
	}
	
	public List<Users> findUserByUserNamePassword(String username,String password) {
		return usersRepository.findUserSession(username, password);
	}

}
