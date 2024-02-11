package com.gl.employeeManagementSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.employeeManagementSystem.entity.User;
import com.gl.employeeManagementSystem.repository.UserRepository;
import com.gl.employeeManagementSystem.security.MyUserDetails;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =userRepository.findByUsername(username);
		
		if(user==null)
			throw new UsernameNotFoundException("Could not fine user");
		
		return new MyUserDetails(user);
	}

}
