package com.example.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

	Car findByName(String name);		//for finding one car from database by using the name of the car  
	Car findByCarid(Long carid);			//for finding one car from database by using the id of the car
	List<Car> findByDriver(Driver driver);	//for finding list of cars belonging to on driver from database by using the name of the driver
	

}