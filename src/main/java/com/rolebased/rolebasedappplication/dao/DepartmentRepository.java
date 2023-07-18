package com.rolebased.rolebasedappplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rolebased.rolebasedappplication.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
