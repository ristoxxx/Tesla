package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.CarRepository;
//
import com.example.demo.domain.Expense;
//
import com.example.demo.domain.ExpenseRepository;

@Controller
public class CarController {
	
	@Autowired
	private ExpenseRepository repository;
	
	@Autowired
	private CarRepository crepository;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = {"/", "/etusivu"})	
    public String expenseList(Model model) {	
        model.addAttribute("expenses", repository.findAll());
        return "etusivu";
	}
	
	@RequestMapping(value = "/tesla")	
    public String expenList(Model model) {	
        model.addAttribute("expenses", repository.findByCar(crepository.findByName("tesla")));
        return "tesla";
	}
	
	@RequestMapping(value = "/golf")	
    public String expList(Model model) {	
        model.addAttribute("expenses", repository.findByCar(crepository.findByName("golf")));
        return "tesla";
	}
	
	@RequestMapping(value = "/main")	
    public String expeList(Model model) {	
        model.addAttribute("expenses", repository.findAll());
        return "main";
	}
	
	@RequestMapping(value = "/editcar")
	public String editcar() {
		return "editcar";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Expense expense){
        repository.save(expense);
        return "redirect:main";
    }
	
	@RequestMapping(value= "/editexpense/{id}", method = RequestMethod.GET)
    public String editbook(@PathVariable("id") Long id, Model model){
    	model.addAttribute("expense", repository.findById(id));  	
    	return "editexpense";
    }
}
