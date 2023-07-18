package com.rolebased.rolebasedappplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rolebased.rolebasedappplication.entity.Department;
import com.rolebased.rolebasedappplication.service.DepartmentService;

/**
 * 
 * @author 10723147
 *
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/home")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}

	/**
	 * 
	 * @param department
	 * @return
	 */
	@PostMapping("/addDepartment")
	public String addNewDepartment(@RequestBody Department department) {
		return departmentService.addNewDepartment(department);

	}

	@GetMapping("/getAllDepartment")
	@PreAuthorize("hasAuthority('ROLE_HR')")
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartment();
	}

	/**
	 * 
	 * @param dptId
	 * @return
	 */
	@GetMapping("/getDeptById/{dptId}")
	@PreAuthorize("hasAuthority('ROLE_EMPLOYEE')")
	public Department getDeptById(@PathVariable int dptId) {
		return departmentService.getDeptById(dptId);
	}

}
