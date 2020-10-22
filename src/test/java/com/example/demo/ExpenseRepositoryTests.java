package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Car;
import com.example.demo.domain.Expense;
import com.example.demo.domain.ExpenseRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class ExpenseRepositoryTests {

	    @Autowired
	    private ExpenseRepository repository;

	    @Test
	    public void findByLastnameShouldReturnExpense() {
	        List<Expense> expenses = repository.findByCompany("Voltti");
	        
	        assertThat(expenses).hasSize(1);
	        assertThat(expenses.get(0).getCompany()).isEqualTo("Voltti");
	    }
	   
	    @Test
	    public void createNewExpense() {
	    	Expense Expense1 = new Expense("K-sähkö", 20.5, 10.3, new Car("golf"));
	    	Expense Expense2 = new Expense("Voltti", 7.5, 3.2, new Car("tesla"));
	    	repository.save(Expense1);
	    	repository.save(Expense2);
	    	assertThat(Expense1.getId()).isNotNull();
	    	assertThat(Expense1.getCar()).isNotNull();
	    }
	    
	    @Test
	    public void deleteExpense() {
	    	List<Expense> Expenses = repository.findByCompany("Voltti");
	    	Long id = Expenses.get(0).getId();
	    	assertThat(Expenses).hasSize(1);
	    	repository.deleteById(id);
	    	List<Expense> newList = repository.findByCompany("Voltti");
	    	assertThat(newList).hasSize(0);
	    }	    
	}