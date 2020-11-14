package com.example.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

	List<Expense> findByCompany(String company); 	//for finding list of expenses beloging to one company(not in use yet)
	List<Expense> findByCar(Car car);				//for finding list of expenses belongin to one car
	
}
