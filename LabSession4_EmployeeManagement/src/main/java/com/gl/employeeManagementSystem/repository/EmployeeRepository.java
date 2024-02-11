package com.gl.employeeManagementSystem.repository;



import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeeManagementSystem.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(String firstName, String lastName);

	List<Employee> findAllByOrderByFirstNameASC(Sort sort);

	//List<Employee> findAll(Sort sort);
	//List<Employee> findAllByOrderByFirstNameASC(String firstName);

//	List<Employee> findByfirstNameContainslastNameContainsAllIgnoreCase(String firstName, String lastName);

}
