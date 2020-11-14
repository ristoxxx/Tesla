package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String company;
    private Double kwh;
    private Double price;
    
    //one car can have many expenses but expense belongs to one car only
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "carid")
    private Car car;
    
    public Expense() {}

	public Expense(String company, Double kwh, Double price,Car car) {
		super();
		this.company = company;
		this.kwh = kwh;
		this.price = price;
		this.car = car;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getKwh() {
		return kwh;
	}

	public void setKwh(Double kwh) {
		this.kwh = kwh;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}