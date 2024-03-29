package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarRepository;
import com.example.demo.domain.DriverRepository;
//
import com.example.demo.domain.Expense;
//
import com.example.demo.domain.ExpenseRepository;

@CrossOrigin
@Controller
public class CarController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//Repository for expenses data
	@Autowired
	private ExpenseRepository repository;
	
	//Repository for car data
	@Autowired
	private CarRepository crepository;
	
	//Repository for driver data(is also user of database when signing in) 
	@Autowired
	private DriverRepository drepository;
	
	//login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	//Show list of cars = main page for admin operations
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/cars", method = RequestMethod.GET)	
    public String expenseLis(Model model) {	
        model.addAttribute("cars", crepository.findAll());
        return "cars";
	}
	
	//Welcome page needed to direct user to his own vehicles
	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)	
    public String exenseLis() {	      
        return "welcome";
	}
	
	//Main page that shows only user related vehicles 
	@RequestMapping(value = "/acars/{id}", method = RequestMethod.GET)	
    public String expensLis(@PathVariable("id") String idu, Model model) {	
        model.addAttribute("cars", crepository.findByDriver(drepository.findByUsername(idu)));
        return "acars";
	}
	
	//Show ALL expenses lines for admin operations
	@RequestMapping(value = "/main", method = RequestMethod.GET)	
    public String expeList(Model model) {	
        model.addAttribute("expenses", repository.findAll());
        return "main";
	}
	
	//Find car related expenses
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
    public String eList(@PathVariable("id") Long ide, Model model) {	
        model.addAttribute("expenses", repository.findByCar(crepository.findByCarid(ide)));
        model.addAttribute("number", ide);
        return "tesla";
	}
	//Edit car page
	@RequestMapping(value= "/editcar/{id}", method = RequestMethod.GET)
    public String editcar(@PathVariable("id") Long id, Model model){
    	model.addAttribute("car", crepository.findById(id)); 
    	return "editcar";
    }
	
	//Add car page
		@RequestMapping(value = "/addcar", method = RequestMethod.GET)
	    public String addCar(Model model){
	    	model.addAttribute("car", new Car());
	    	model.addAttribute("drivers", drepository.findAll());
	        return "addcar";
		}
	
	
	//Save car page
	@RequestMapping(value = "/savecar", method = RequestMethod.POST)
    public String save(Car car){
        crepository.save(car);
        return "redirect:welcome";
    }
	
	//Delete car. Admin only
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deletecar/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable("id") Long cid, Model model) {
    	crepository.deleteById(cid);
        return "redirect:../cars";
    }
	
	//Save expense. redirects to welcome page because too much work to make this nice
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Expense expense){
        repository.save(expense);
        return "redirect:welcome";
    }
	//Edit expense page
	@RequestMapping(value= "/editexpense/{id}", method = RequestMethod.GET)
    public String editbook(@PathVariable("id") Long id, Model model){
    	model.addAttribute("expense", repository.findById(id));  	
    	return "editexpense";
    }
	//Add expense page
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addExpense(@PathVariable("id") Long ids, Model model){
    	model.addAttribute("expense", new Expense());
    	model.addAttribute("car", ids);
        return "addexpense";
	}
	
	//Delete expense. Admin only
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteExpense(@PathVariable("id") Long eid, Model model) {
    	repository.deleteById(eid);
        return "redirect:../main";
    }
	
}