package com.example.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

	List<Expense> findByCompany(String company);
	List<Expense> findByCar(Car car);
	
}
