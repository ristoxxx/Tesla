package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Driver, Long> {

	Expense findByUsername(String company);

}
