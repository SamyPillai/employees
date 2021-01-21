package com.example.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employees.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

	Employees findByEmployeeId(Long employeeID);

}
