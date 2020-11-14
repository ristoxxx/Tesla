package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long> {

	Driver findByUsername(String username);
	

}
