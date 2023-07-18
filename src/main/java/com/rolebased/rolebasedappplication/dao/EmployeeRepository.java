package com.rolebased.rolebasedappplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolebased.rolebasedappplication.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Optional<Employee> findByEmpName(String emp_name);
}
