package com.gl.employeeManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.gl.employeeManagementSystem.entity.User;




public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
	

}

