package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.demo.domain.Driver;
import com.example.demo.domain.DriverRepository;

@SpringBootApplication
public class TeslaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeslaApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(DriverRepository urepository) {
		return (args) -> {
			//log.info("save a couple of students");
			
			//crepository.save(new Category("Kauhu"));
			//crepository.save(new Category("Musiikki"));
			//crepository.save(new Category("Scifi"));

			//brepository.save(new Book("Kalevi", "Mäkelä", "Avaruus", "ISBN", 2015, crepository.findByName("Scifi").get(0)));
			//brepository.save(new Book("Joonas", "Mäkelä", "Oodi", "962-234 533", 1999, crepository.findByName("Musiikki").get(0)));
			//brepository.save(new Book("Mikko", "Mäkelä", "Java", "824-321 234", 2005, crepository.findByName("Scifi").get(0)));
			
			Driver user1 = new Driver("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			Driver user2 = new Driver("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
//			String nimi = "Scifi";
//			List<Book> x = brepository.findByCategory(crepository.findByName(nimi).get(0));
//			int y = x.get(0).getYear();
//			//crepository.findByName(null)
//			int z = x.get(1).getYear();
//			System.out.println((y+z)+"moi");
		};
	}

}
