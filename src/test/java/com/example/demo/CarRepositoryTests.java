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



@RunWith(SpringRunner.class)
@DataJpaTest

class CarRepositoryTests {

    @Autowired
    private CarRepository repository;
    
    @Test
    public  void findCar() {
    	Car car = new Car("K");	    	
    	repository.save(car);
    	
    	Car testCar = repository.findByName("K");
    	
    	assertThat(testCar.getName()).isNotNull();
    	
	}
    
    @Test
    public void createNewCar() {
    	Car Car = new Car("K");	    	
    	repository.save(Car);
    	assertThat(Car.getCarid()).isNotNull();
    }
    
    @Test
    public void deleteCar() {
    	
    	Car Car1 = new Car("P");	    	
    	repository.save(Car1);
    	
    	Car testCar1 = repository.findByName("P");
    	assertThat(testCar1.getName()).isNotNull();
    	
    	Long id = testCar1.getCarid();
    	repository.deleteById(id);
    	
    	testCar1 = repository.findByName("P");
    	assertThat(testCar1).isNull();
		
	}

}