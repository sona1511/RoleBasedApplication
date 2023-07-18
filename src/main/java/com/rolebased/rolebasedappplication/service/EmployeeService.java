package com.rolebased.rolebasedappplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rolebased.rolebasedappplication.dao.EmployeeRepository;
import com.rolebased.rolebasedappplication.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 
	 * @param employee
	 * @return
	 */
	public String addNewEmployee(Employee employee) {
		employee.setEmpPassword(passwordEncoder.encode(employee.getEmpPassword()));
		employeeRepository.save(employee);
		return "employee added successfully";

	}

}
