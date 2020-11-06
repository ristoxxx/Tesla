package com.example.demo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

	Car findByName(String username);
	Car findByCarid(Long carid);
	

}