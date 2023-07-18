package com.rolebased.rolebasedappplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rolebased.rolebasedappplication.entity.Employee;
import com.rolebased.rolebasedappplication.service.EmployeeService;

/**
 * 
 * @author 10723147
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping("/addEmployee")
	public String addNewEmployee(@RequestBody Employee employee) {
		return employeeService.addNewEmployee(employee);

	}
}
