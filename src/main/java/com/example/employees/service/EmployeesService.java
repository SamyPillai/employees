package com.example.employees.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employees.entity.Employees;
import com.example.employees.entity.EmployeesSpecialization;
import com.example.employees.repository.EmployeesRepository;
import com.example.employees.repository.EmployeesSpecializationRepository;

@Service
public class EmployeesService {
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private EmployeesSpecializationRepository employeesSpecializationRepository;

	public Employees saveEmployees(Employees employees) {
		return employeesRepository.save(new Employees(employees.getEmployeeId(),employees.getType(),employees.getDesignation(), 
				employees.getFirstName(),employees.getLastName(),employees.getDateOfBirth(),employees.getGender(),
				employees.getContactNumber(),employees.getEmailId(),employees.getAddress(),employees.getCity(),
				employees.getState(),employees.getZipCode(),employees.getSalary()));
	}

	public void deleteEmployees(Long employeeId) {
		employeesRepository.deleteById(employeeId);
	}
	
	public void deleteEmployeesSpecialization(String iden, String specialization) {
		employeesSpecializationRepository.deleteBySpecialization(iden,specialization);
	}
	
	public Employees findEmployeesById(Long employeeID) {
		return employeesRepository.findByEmployeeId(employeeID);
	}

	public EmployeesSpecialization saveEmployeesSpecialization(EmployeesSpecialization employeesSpecialization) {
		return employeesSpecializationRepository.save(new EmployeesSpecialization(employeesSpecialization.getEmployeeId(),
				employeesSpecialization.getSpecialization(),employeesSpecialization.getYearsOfExperience()));
	}

	public List<EmployeesSpecialization> getSpecializationById(Long employeeID) {
		return employeesSpecializationRepository.findByEmployeeId(employeeID);
	}

}
