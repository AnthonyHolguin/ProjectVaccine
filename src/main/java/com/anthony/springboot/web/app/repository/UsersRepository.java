package com.anthony.springboot.web.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anthony.springboot.web.app.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{ 

	@Query("select u.type  from Users u where u.user_name= ?1 and u.password = ?2")
	String findUserSession(String username,String password);
}
 