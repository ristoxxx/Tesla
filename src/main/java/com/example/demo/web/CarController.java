package com.example.demo.web;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.demo.domain.CarRepository;
//import com.example.demo.domain.Expense;
//import com.example.demo.domain.ExpenseRepository;

@Controller
public class CarController {
	
	//@Autowired
	//private ExpenseRepository repository;
	
	//@Autowired
	//private CarRepository crepository;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "/editcar")
	public String editcar() {
		return "editcar";
	}
	
	@RequestMapping(value = "/editexpense")
	public String editexpense(  ) {
		return "editexpense";
	}

}
