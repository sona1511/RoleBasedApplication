package com.rolebased.rolebasedappplication.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rolebased.rolebasedappplication.dao.EmployeeRepository;
import com.rolebased.rolebasedappplication.entity.Employee;

public class CustomerUserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> emp = employeeRepository.findByEmpName(username);
		return emp.map(CustomUserDetail::new)
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}

}
