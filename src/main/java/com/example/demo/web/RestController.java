package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarRepository;
import com.example.demo.domain.Driver;
import com.example.demo.domain.DriverRepository;
import com.example.demo.domain.Expense;

import com.example.demo.domain.ExpenseRepository;

@CrossOrigin
@Controller
public class RestController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//Repository for expenses data
	@Autowired
	private ExpenseRepository repository;
	
	//Repository for car data
	@Autowired
	private CarRepository crepository;
	
	@Autowired
	private DriverRepository drepository;
	
	//list of cars and expenses REST 
	@RequestMapping(value = "/rest/cars", method = RequestMethod.GET)	
    public @ResponseBody List<Car> expenseLis() {	
        return (List<Car>) crepository.findAll();
        
	}
	
	//find user related expenses
	@RequestMapping(value = "/rest/acars/{id}", method = RequestMethod.GET)	
    public @ResponseBody List<Car> epenseLis(@PathVariable("id") String did) {	
        return (List<Car>) crepository.findByDriver(drepository.findByUsername(did));
        
	}
	
	//Show all expenses REST
	@RequestMapping(value = "/rest/main", method = RequestMethod.GET)	
    public @ResponseBody List<Expense> expeList() {	
        return (List<Expense>) repository.findAll();
        
	}
	
	//Find car related expenses REST
	@RequestMapping(value = "/rest/{id}", method = RequestMethod.GET)	
    public @ResponseBody List<Expense> exp(@PathVariable("id") Long ide) {	
         return repository.findByCar(crepository.findByCarid(ide));
    
	}
	
	//Add car
	@RequestMapping(value = "/rest/addcar", method = RequestMethod.POST)
		public @ResponseBody Car addCarRest(@RequestBody Car car) {    	
	    return crepository.save(car);
	}
//	
//	
//	//Save car NOT READY
//	@RequestMapping(value = "/savecar", method = RequestMethod.POST)
//    public String save(Car car){
//        crepository.save(car);
//        return "redirect:cars";
//    }
//	
	//Delete car. admin only
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "rest/deletecar/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable("id") Long cid, Model model) {
    	crepository.deleteById(cid);
        return "redirect:../cars";
    }
	
	//Save expense
	@RequestMapping(value = "/rest/save", method = RequestMethod.POST)
    public @ResponseBody Expense save(@RequestBody Expense expense){
        return repository.save(expense);

    }

//	//Add expense NOT READY
//	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
//    public String addExpense(@PathVariable("id") Long ids, Model model){
//    	model.addAttribute("expense", new Expense());
//    	model.addAttribute("car", ids);
//        return "addexpense";
//	}
//	
//	//Delete expense NOT READY
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String deleteExpense(@PathVariable("id") Long eid, Model model) {
//    	repository.deleteById(eid);
//        return "redirect:../cars";
//    }
//	
}
