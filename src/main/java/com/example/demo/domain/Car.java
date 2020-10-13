package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long carid;
    private String name;
    private int sum = 0;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
	private List<Expense> expenses;

	public Car() {}
    
    public Car(String name) {
    	super();
    	this.name = name;
    }

	public Long getCarid() {
		return carid;
	}

	public void setCarid(Long carid) {
		this.carid = carid;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
