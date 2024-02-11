package com.gl.employeeManagementSystem.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.service.EmployeeService;



@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// handler method to handle list employees and return mode and view
	@GetMapping("/employees")
	public String listemployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}

	@GetMapping("/employees/new")
	public String createemployeeForm(Model model) {

		// create employee object to hold employee form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";

	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String editemployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateemployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {

		// get employee from database by id
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		// save updated employee object
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";
	}

	// Order by firstnname

//	@GetMapping("/employees/order")
//	public String orderBy(@RequestParam("firstName") String firstName , Model model) {
//	List<Employee> listEmployees = employeeService.findAllByOrderByFirstNameASC(firstName);
//	model.addAttribute(listEmployees);
//	return "/employees";
//	}
	
	
	@RequestMapping("/employees")
	public String sorting(@RequestParam("firstName") String firstName,Model model) {
		
		List<Employee> employee=employeeService.findAllByOrderByFirstNameASC(firstName);
		model.addAttribute("employee", employee);
		return "redirect:/employees";
	}
//	
	// handler method to handle delete employee request
	@GetMapping("/employees/{id}")
	public String deleteemployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	
	
	@GetMapping("/employees/search")
	public String search(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			Model theModel) {

		// check names, if both are empty then just give list of all Employee

		if (firstName.trim().isEmpty() && lastName.trim().isEmpty()) {
			return "redirect:/employees";
		}
		else {
			// else, search by first name and last name
			List<Employee> theemployees =
					employeeService.searchBy(firstName, lastName);

			// add to the spring model
			theModel.addAttribute("employee", theemployees);

			// send to list-Employee
			return "/employees";
		}

	}
	
	
	@RequestMapping("employees/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
