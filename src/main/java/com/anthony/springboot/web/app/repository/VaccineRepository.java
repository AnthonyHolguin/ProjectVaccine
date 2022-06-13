package com.anthony.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anthony.springboot.web.app.model.Vaccine;

public interface VaccineRepository extends  JpaRepository<Vaccine, Long>{

}
