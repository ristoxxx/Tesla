package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long> {

	Driver findByUsername(String username);

}
