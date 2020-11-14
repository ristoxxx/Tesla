package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Car {
	//lines to automatically create unique id
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long carid;
    //car object properties
    private String name;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id")
    private Driver driver;
    
    //joining database tables so that every car have list of expenses
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
	private List<Expense> expenses;
    
    
    
    //empty constructor
	public Car() {}
    
	//actual constructor
    public Car(String name, Driver driver) {
    	super();//id is automatically created and is inherited from super class
    	this.name = name;
    	this.driver = driver;
    }
    //rest is just basic getters and setters
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
	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}



}
