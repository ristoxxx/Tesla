package com.example.demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

	List<Expense> findByCompany(String company);
	List<Expense> findByCar(Car car);
	@Query(value = "SELECT sum(price) FROM Expense")
    public Long sumQuantities();
}
