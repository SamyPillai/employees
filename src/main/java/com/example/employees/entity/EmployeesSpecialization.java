package com.example.employees.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EmployeesSpecializationIdentity.class)
@Table(name = "employees_specialization")
public class EmployeesSpecialization implements Serializable {
	
	@Id
	@Column(name = "employeeId")
	private Long employeeId;
	
	@Id
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "yearsOfExperience")
	private Integer yearsOfExperience;

	public EmployeesSpecialization() {
		
	}

	public EmployeesSpecialization(Long employeeId, String specialization, Integer yearsOfExperience) {
		super();
		this.employeeId = employeeId;
		this.specialization = specialization;
		this.yearsOfExperience = yearsOfExperience;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

}
