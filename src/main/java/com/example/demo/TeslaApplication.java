package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarRepository;
import com.example.demo.domain.Driver;
import com.example.demo.domain.DriverRepository;
import com.example.demo.domain.Expense;
import com.example.demo.domain.ExpenseRepository;

@SpringBootApplication
public class TeslaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeslaApplication.class, args);
	}
	//command line runner to add some data to database
	@Bean
	public CommandLineRunner teslaDemo(DriverRepository urepository, CarRepository crepository, ExpenseRepository erepository) {
		return (args) -> {
		
			crepository.deleteAll();
			
			crepository.save(new Car("golf"));
			crepository.save(new Car("tesla"));
			crepository.save(new Car("bmw"));
					
			erepository.deleteAll();
			erepository.save(new Expense("K-sähkö", 20.5, 10.3, crepository.findByName("golf")));
			erepository.save(new Expense("Voltti", 7.5, 3.2, crepository.findByName("tesla")));
			erepository.save(new Expense("ärrävirta", 20.5, 10.3, crepository.findByName("golf")));
			erepository.save(new Expense("motomaatti", 7.5, 3.2, crepository.findByName("tesla")));
			
			
			//clear user data
			urepository.deleteAll();
			//add some users
			Driver user1 = new Driver("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			Driver user2 = new Driver("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};
	}
}
