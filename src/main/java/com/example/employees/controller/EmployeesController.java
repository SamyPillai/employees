package com.example.employees.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employees.entity.Employees;
import com.example.employees.entity.EmployeesSpecialization;
import com.example.employees.repository.EmployeesRepository;
import com.example.employees.repository.EmployeesSpecializationRepository;
import com.example.employees.service.EmployeesService;

// This is the code to connect to ReactJS
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/employees")
public class EmployeesController {
	
	@Autowired
	private EmployeesService employeesService;
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private EmployeesSpecializationRepository employeesSpecializationRepository;
	
	// Insert an Employee - Working 
	@PostMapping("/employee_insert/")
	public Employees saveEmployees(@RequestBody Employees employees) {
		return employeesService.saveEmployees(employees);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmloyees(@PathVariable("id") Long EmployeeId) {
		employeesService.deleteEmployees(EmployeeId);
	}
	
	@GetMapping("/get_all/")
	public List<Employees> showEmployees() {
		List<Employees> employees = this.employeesRepository.findAll();
		return employees;
	}
	
	// Get an Employee - Working 
	@GetMapping("/employee_get/{id}")
	public Employees findEmployeesById(@PathVariable("id") Long EmployeeID) {
		return employeesService.findEmployeesById(EmployeeID);
	}
	
	// Update an Employee
	@PutMapping("/employee_update/{id}")
	public Employees saveEmployees(@PathVariable("id") Long EmployeeID, @RequestBody Employees employeeDetails) {
		
		Employees employee = employeesService.findEmployeesById(EmployeeID);
		
		employee.setAddress(employeeDetails.getAddress());
		employee.setCity(employeeDetails.getCity());
		employee.setContactNumber(employeeDetails.getContactNumber());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setDesignation(employeeDetails.getDesignation());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setGender(employeeDetails.getGender());
		employee.setSalary(employeeDetails.getSalary());
		employee.setState(employeeDetails.getState());
		employee.setType(employeeDetails.getType());
		employee.setZipCode(employeeDetails.getZipCode());
		
		Employees updatedEmployee = employeesService.saveEmployees(employee);
		return updatedEmployee;
	}
	
	// Insert a Specialization
	@PostMapping("/specialization_insert/")
	public EmployeesSpecialization saveEmployeesSpecialization(@RequestBody EmployeesSpecialization employeesSpecialization) {
		return employeesService.saveEmployeesSpecialization(employeesSpecialization);
	}
	
	// Get the list of Specializations
	@GetMapping("/specialization_get/{id}")
	public List<EmployeesSpecialization> getSpecializationById(@PathVariable("id") Long EmployeeID) {
		return employeesService.getSpecializationById(EmployeeID);
	}
	
	@DeleteMapping("/specialization_delete/{id}")
	public void deleteEmployeesSpecialization(@PathVariable("id") String EmployeeId) {
		String[] key = EmployeeId.split(",");
		String iden = key[0];
		String specialization = key[1];
		System.out.println(iden);
		System.out.println(specialization);
	
		employeesService.deleteEmployeesSpecialization(iden,specialization);
	}
	
	// Update a Specialization
	@PutMapping("/specialization_update/{id}")
	public EmployeesSpecialization updateSpecialization(@PathVariable("id") Long EmployeeID, @RequestBody EmployeesSpecialization specializationDetails) {
		
		List<EmployeesSpecialization> specialization = employeesService.getSpecializationById(EmployeeID);
		
		Iterator<EmployeesSpecialization> iterator = (Iterator<EmployeesSpecialization>) specialization.iterator();
		
		EmployeesSpecialization specialization_details = new EmployeesSpecialization();
		
		 while (iterator.hasNext()) {
			 EmployeesSpecialization specialization_temp = iterator.next();
		        if (specialization_temp.getSpecialization().equals(specializationDetails.getSpecialization())) {
		        	specialization_details = specialization_temp;
		        	break;
		        }
		    }
		
		specialization_details.setYearsOfExperience(specializationDetails.getYearsOfExperience()); 
		 
		EmployeesSpecialization updatedSpecialization = employeesService.saveEmployeesSpecialization(specialization_details);
		return updatedSpecialization;
	}
}
