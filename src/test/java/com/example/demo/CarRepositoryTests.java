package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarRepository;
import com.example.demo.domain.Driver;
import com.example.demo.domain.DriverRepository;



@RunWith(SpringRunner.class)
@DataJpaTest

class CarRepositoryTests {

    @Autowired
    private CarRepository repository;
    //private DriverRepository urepository;
    Driver user2 = new Driver("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
    //urepository.save(user2);
    
    @Test
    public  void findCar() {
    	Car car = new Car("K", user2);	    	
    	repository.save(car);
    	
    	Car testCar = repository.findByName("K");
    	
    	assertThat(testCar.getName()).isNotNull();
    	
	}
    
    @Test
    public void createNewCar() {
    	Car Car = new Car("K", user2);	    	
    	repository.save(Car);
    	assertThat(Car.getCarid()).isNotNull();
    }
    
    @Test
    public void deleteCar() {
    	
    	Car Car1 = new Car("P", user2);	    	
    	repository.save(Car1);
    	
    	Car testCar1 = repository.findByName("P");
    	assertThat(testCar1.getName()).isNotNull();
    	
    	Long id = testCar1.getCarid();
    	repository.deleteById(id);
    	
    	testCar1 = repository.findByName("P");
    	assertThat(testCar1).isNull();	
	}
}