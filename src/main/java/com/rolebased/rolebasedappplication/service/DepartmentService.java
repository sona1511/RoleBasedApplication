package com.rolebased.rolebasedappplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolebased.rolebasedappplication.dao.DepartmentRepository;
import com.rolebased.rolebasedappplication.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();

	}

	/**
	 * 
	 * @param dpt_id
	 * @return
	 */
	public Department getDeptById(int dpt_id) {
		return departmentRepository.findById(dpt_id).get();
	}

	/**
	 * 
	 * @param department
	 * @return
	 */
	public String addNewDepartment(Department department) {
		departmentRepository.save(department);
		return "department successfully added";
	}

}
