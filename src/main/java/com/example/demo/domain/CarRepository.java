package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Driver, Long> {

	Car findByUsername(String username);

}