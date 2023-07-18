package com.rolebased.rolebasedappplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	int dptId;

	String dptName;

	public Department() {

	}

	public Department(int dptId, String dptName) {
		super();
		this.dptId = dptId;
		this.dptName = dptName;
	}

	public int getDptId() {
		return dptId;
	}

	public void setDptId(int dptId) {
		this.dptId = dptId;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	@Override
	public String toString() {
		return "Department [dptId=" + dptId + ", dptName=" + dptName + "]";
	}

}
