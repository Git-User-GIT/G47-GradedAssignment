package com.gl.employeeManagementSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.repository.EmployeeRepository;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchBy(String firstName, String lastName) {
		// TODO Auto-generated method stub
		List<Employee> employee=employeeRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(firstName, lastName);
		return employee;
	}
	
	

	@Override
	public List<Employee> findAllByOrderByFirstNameASC(String firstName) {
		// TODO Auto-generated method stub
		return employeeRepository.findAllByOrderByFirstNameASC(Sort.by(Sort.Direction.ASC , firstName));
	}

}
