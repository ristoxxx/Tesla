package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarRepository;
//
import com.example.demo.domain.Expense;
//
import com.example.demo.domain.ExpenseRepository;

@Controller
public class CarController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ExpenseRepository repository;
	
	@Autowired
	private CarRepository crepository;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = {"/", "/cars"}, method = RequestMethod.GET)	
    public String expenseLis(Model model) {	
        model.addAttribute("cars", crepository.findAll());
        return "cars";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)	
    public String expeList(Model model) {	
        model.addAttribute("expenses", repository.findAll());
        return "main";
	}
	
	@RequestMapping(value = "/editcar", method = RequestMethod.GET)
	public String editcar(Model model) {
		model.addAttribute("cars", crepository.findAll());
		return "editcar";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
    public String eList(@PathVariable("id") Long ide, Model model) {	
        model.addAttribute("expenses", repository.findByCar(crepository.findByCarid(ide)));
        model.addAttribute("number", ide);
        return "tesla";
	}
	
	@RequestMapping(value= "/editcar/{id}", method = RequestMethod.GET)
    public String editcar(@PathVariable("id") Long id, Model model){
    	model.addAttribute("car", crepository.findById(id));  	
    	return "editcar";
    }
	
	@RequestMapping(value = "/savecar", method = RequestMethod.POST)
    public String save(Car car){
        crepository.save(car);
        return "redirect:cars";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Expense expense){
        repository.save(expense);
        return "redirect:cars";
    }
	
	@RequestMapping(value= "/editexpense/{id}", method = RequestMethod.GET)
    public String editbook(@PathVariable("id") Long id, Model model){
    	model.addAttribute("expense", repository.findById(id));  	
    	return "editexpense";
    }
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addExpense(@PathVariable("id") Long ids, Model model){
    	model.addAttribute("expense", new Expense());
    	model.addAttribute("car", ids);
        return "addexpense";
	}
	
	//Delete student
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteExpense(@PathVariable("id") Long eid, Model model) {
    	repository.deleteById(eid);
        return "redirect:../cars";
    }
	
}